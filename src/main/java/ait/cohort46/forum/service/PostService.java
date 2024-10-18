package ait.cohort46.forum.service;

import ait.cohort46.forum.dto.AddPostDto;
import ait.cohort46.forum.dto.PostDto;
import ait.cohort46.forum.dto.UpdatePostDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    PostDto addPost(String author, AddPostDto addPostDto);

    PostDto deletePost(String id);

    PostDto updatePost(String id, UpdatePostDto updatePostDto);

    void addLike(String id);

    PostDto addComment(String id, String author, String comment);

    PostDto findPostById(String id);

    List<PostDto> findPostsByAuthor(String author);

    List<PostDto> findPostsByTags(List<String> tags);

    List<PostDto> findPostsByPeriod(LocalDateTime dateFrom, LocalDateTime dateTo);


}
