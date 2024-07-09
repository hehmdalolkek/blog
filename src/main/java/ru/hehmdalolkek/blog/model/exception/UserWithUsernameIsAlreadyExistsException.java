package ru.hehmdalolkek.blog.model.exception;

public class UserWithUsernameIsAlreadyExistsException extends RuntimeException {
    public UserWithUsernameIsAlreadyExistsException(String message) {
        super(message);
    }
}
