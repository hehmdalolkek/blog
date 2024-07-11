package ru.hehmdalolkek.blog.web.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import ru.hehmdalolkek.blog.web.dto.UserDto;

public class PasswordMatchConstraintValidator implements ConstraintValidator<PasswordMatch, UserDto> {

    private String fieldNameForError;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.fieldNameForError = constraintAnnotation.fieldNameForError();
    }

    @SneakyThrows
    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {
        boolean isValid = value.getPassword() != null
                && value.getRepeatPassword() != null
                && value.getPassword().equals(value.getRepeatPassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode(this.fieldNameForError)
                    .addConstraintViolation();
        }

        return isValid;
    }

}
