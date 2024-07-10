package ru.hehmdalolkek.blog.web.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostDto {

    UUID id;

    String title;

    String content;

    UserDto author;

    LocalDateTime creationDate;

}
