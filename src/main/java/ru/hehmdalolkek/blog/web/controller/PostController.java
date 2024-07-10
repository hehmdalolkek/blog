package ru.hehmdalolkek.blog.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hehmdalolkek.blog.model.Post;
import ru.hehmdalolkek.blog.service.PostService;
import ru.hehmdalolkek.blog.web.mapper.PostMapper;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    @GetMapping
    public String initPosts(Principal principal, Model model) {
        List<Post> posts = this.postService.getAllPosts();
        model.addAttribute("username", principal.getName());
        model.addAttribute("posts", this.postMapper.postsToPostDtos(posts));
        return "posts";
    }

}
