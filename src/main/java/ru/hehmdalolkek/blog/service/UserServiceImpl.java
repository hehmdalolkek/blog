package ru.hehmdalolkek.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hehmdalolkek.blog.dao.UserDao;
import ru.hehmdalolkek.blog.model.Role;
import ru.hehmdalolkek.blog.model.User;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserDao userDao;

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

}
