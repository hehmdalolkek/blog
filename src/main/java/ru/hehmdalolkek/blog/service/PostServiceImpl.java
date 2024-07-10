package ru.hehmdalolkek.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hehmdalolkek.blog.dao.PostDao;
import ru.hehmdalolkek.blog.model.Post;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllPosts() {
        return this.postDao.findAll(Sort.by("creationDate").descending());
    }

}
