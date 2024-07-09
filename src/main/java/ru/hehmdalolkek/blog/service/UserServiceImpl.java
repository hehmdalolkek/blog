package ru.hehmdalolkek.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hehmdalolkek.blog.dao.UserDao;
import ru.hehmdalolkek.blog.model.Role;
import ru.hehmdalolkek.blog.model.User;
import ru.hehmdalolkek.blog.model.exception.UserWithUsernameIsAlreadyExistsException;
import ru.hehmdalolkek.blog.web.dto.UserDto;
import ru.hehmdalolkek.blog.web.mapper.UserMapper;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundedUser = this.userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username=%s not found"
                        .formatted(username)));
        return org.springframework.security.core.userdetails.User.builder()
                .username(foundedUser.getUsername())
                .password(foundedUser.getPassword())
                .authorities(foundedUser.getRoles().stream()
                        .map(Role::getAuthority)
                        .map(SimpleGrantedAuthority::new)
                        .toList())
                .build();
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.userMapper.userDtoToUser(userDto);
        boolean isExists = this.userDao.existsByUsername(user.getUsername());
        if (isExists) {
            throw new UserWithUsernameIsAlreadyExistsException("User with username=%s is already exists"
                    .formatted(user.getUsername()));
        }
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return this.userMapper.userToUserDto(this.userDao.save(user));
    }

}
