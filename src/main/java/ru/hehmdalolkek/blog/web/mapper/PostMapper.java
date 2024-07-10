package ru.hehmdalolkek.blog.web.mapper;

import org.mapstruct.Mapper;
import ru.hehmdalolkek.blog.model.Post;
import ru.hehmdalolkek.blog.web.dto.PostDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);

    List<PostDto> postsToPostDtos(List<Post> posts);

}
