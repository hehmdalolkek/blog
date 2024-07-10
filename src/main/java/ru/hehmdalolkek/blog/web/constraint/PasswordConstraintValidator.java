package ru.hehmdalolkek.blog.web.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.passay.*;

import java.util.List;
import java.util.ResourceBundle;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @SneakyThrows
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        MessageResolver resolver =
                new ResourceBundleMessageResolver(ResourceBundle.getBundle("locale/messages"));

        PasswordValidator validator = new PasswordValidator(
                resolver,
                // length between 8 and 16 characters
                new LengthRule(8, 16),

                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, 1),

                // at least one symbol (special character)
                new CharacterRule(EnglishCharacterData.Special, 1),

                // define some illegal sequences that will fail when >= 5 chars long
                // alphabetical is of the form 'abcde', numerical is '34567', qwery is 'asdfg'
                // the false parameter indicates that wrapped sequences are allowed; e.g. 'xyzabc'
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),

                // no whitespace
                new WhitespaceRule());

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        List<String> messages = validator.getMessages(result);
        String message = String.join("; ", messages) + ";";
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }

}
