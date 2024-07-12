package ru.hehmdalolkek.blog.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.hehmdalolkek.blog.model.exception.UserWithUsernameIsAlreadyExistsException;

import java.util.Locale;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class UserControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(UserWithUsernameIsAlreadyExistsException.class)
    public String handleUserWithUsernameIsAlreadyExistsException(UserWithUsernameIsAlreadyExistsException e,
                                                                 RedirectAttributes model, Locale locale) {
        model.addFlashAttribute("errorUsername", messageSource.getMessage(
                "exception.username.exists", new Object[]{}, locale));
        return "redirect:/registration";
    }

}
