package ru.hehmdalolkek.blog.web.mapper;

import org.mapstruct.Mapper;
import ru.hehmdalolkek.blog.model.User;
import ru.hehmdalolkek.blog.web.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
