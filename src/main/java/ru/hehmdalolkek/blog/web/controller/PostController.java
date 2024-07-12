package ru.hehmdalolkek.blog.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hehmdalolkek.blog.model.Post;
import ru.hehmdalolkek.blog.service.PostService;
import ru.hehmdalolkek.blog.web.controller.util.ControllerUtil;
import ru.hehmdalolkek.blog.web.mapper.PostMapper;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    private final ControllerUtil controllerUtil;

    @GetMapping
    public String initPosts(Principal principal, Model model) {
        String username = this.controllerUtil.getUsernameFromPrincipal(principal);
        List<Post> posts = this.postService.getAllPosts();
        model.addAttribute("username", username);
        model.addAttribute("posts", this.postMapper.postsToPostDtos(posts));
        return "posts";
    }

}
