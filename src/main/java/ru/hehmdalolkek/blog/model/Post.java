package ru.hehmdalolkek.blog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "posts")
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id;

        String title;

        String content;

        @ManyToOne
        @JoinColumn(name = "author_id")
        User author;

        @CreationTimestamp
        @Column(name = "creation_date")
        LocalDateTime creationDate;

}
