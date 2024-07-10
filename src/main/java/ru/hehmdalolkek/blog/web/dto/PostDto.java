package ru.hehmdalolkek.blog.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostDto {

    UUID id;

    @NotBlank
    @Size(min = 1, max = 128)
    String title;

    @NotBlank
    @Size(min = 32, max = 20000)
    String content;

    UserDto author;

    LocalDateTime creationDate;

}
