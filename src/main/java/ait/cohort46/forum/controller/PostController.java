package ait.cohort46.forum.controller;

import ait.cohort46.forum.dto.AddPostDto;
import ait.cohort46.forum.dto.PostDto;
import ait.cohort46.forum.dto.UpdatePostDto;
import ait.cohort46.forum.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/forum/post/{author}")
    public PostDto addPost(@PathVariable String author, @RequestBody AddPostDto addPostDto) {
        return postService.addPost(author, addPostDto);
    }

    @DeleteMapping("/forum/post/{id}")
    public PostDto deletePost(@PathVariable String id) {
        return postService.deletePost(id);
    }

    @PatchMapping("/forum/post/{id}")
    public PostDto updatePost(@PathVariable String id, @RequestBody UpdatePostDto updatePostDto) {
        return postService.updatePost(id, updatePostDto);
    }

    @PatchMapping("/forum/post/{id}/like")
    public void addLike(@PathVariable String id) {
        postService.addLike(id);
    }

    @PatchMapping("/forum/post/{id}/comment/{author}")
    public PostDto addComment(@PathVariable String id, @PathVariable String author, @RequestBody String comment) {
        return postService.addComment(id, author, comment);
    }

    @GetMapping("/forum/post/{id}")
    public PostDto findPostById(@PathVariable String id) {
        return postService.findPostById(id);
    }

    @GetMapping("/forum/posts/author/{author}")
    public List<PostDto> findPostsByAuthor(String author) {
        return postService.findPostsByAuthor(author);
    }

    @GetMapping("/forum/posts/tags")
    public List<PostDto> findPostsByTags(@RequestParam List<String> values) {
        return postService.findPostsByTags(values);
    }

    @GetMapping("/forum/posts/period")
    public List<PostDto> findPostsByPeriod(@RequestParam LocalDateTime dateFrom, @RequestParam LocalDateTime dateTo) {
        return postService.findPostsByPeriod(dateFrom, dateTo);
    }
}
