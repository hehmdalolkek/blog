package ru.hehmdalolkek.blog.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.hehmdalolkek.blog.model.Role;
import ru.hehmdalolkek.blog.web.constraint.PasswordMatch;
import ru.hehmdalolkek.blog.web.constraint.ValidPassword;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@PasswordMatch(message = "{validation.user.password.match}")
@Data
public class UserDto {

        UUID id;

        @NotBlank(message = "{validation.not-blank}")
        @Size(min = 4, max = 32, message = "{validation.user.username.size}")
        String username;

        @ValidPassword
        String password;

        String repeatPassword;

        Set<Role> roles;

        LocalDateTime registrationDate;

}
