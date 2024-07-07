package ru.hehmdalolkek.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hehmdalolkek.blog.model.Post;

import java.util.UUID;

@Repository
public interface PostDao extends JpaRepository<Post, UUID> {
}
