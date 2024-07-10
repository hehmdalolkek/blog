package ru.hehmdalolkek.blog.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostDto {

    UUID id;

    @NotBlank(message = "{validation.not-blank}")
    @Size(min = 1, max = 128, message = "{validation.post.title.size}")
    String title;

    @NotBlank(message = "{validation.not-blank}")
    @Size(min = 32, max = 20000, message = "{validation.post.content.size}")
    String content;

    UserDto author;

    LocalDateTime creationDate;

}
