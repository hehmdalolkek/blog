package ru.hehmdalolkek.blog.web.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.hehmdalolkek.blog.web.dto.UserDto;

public class PasswordMatchConstraintValidator implements ConstraintValidator<PasswordMatch, UserDto> {
    @Override
    public boolean isValid(UserDto user, ConstraintValidatorContext context) {
        return
                user.getPassword() != null
                && user.getRepeatPassword() != null
                && user.getRepeatPassword().equals(user.getPassword());
    }
}
