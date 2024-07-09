package ru.hehmdalolkek.blog.web.dto;

import lombok.Data;
import ru.hehmdalolkek.blog.model.Role;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {

        UUID id;

        String username;

        String password;

        String repeatPassword;

        Set<Role> roles;

        LocalDateTime registrationDate;

}
