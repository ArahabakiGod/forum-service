package ait.cohort46.forum.controller;

import ait.cohort46.forum.dto.AddPostDto;
import ait.cohort46.forum.dto.PostDto;
import ait.cohort46.forum.dto.UpdatePostDto;
import ait.cohort46.forum.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/forum")
public class PostController {
    private final PostService postService;

    @PostMapping("/post/{author}")
    public PostDto addPost(@PathVariable String author, @RequestBody AddPostDto addPostDto) {
        PostDto postDto = postService.addPost(author, addPostDto);
        System.out.println("AddPost");
        return postDto;
    }

    @DeleteMapping("/post/{id}")
    public PostDto deletePost(@PathVariable String id) {
        return postService.deletePost(id);
    }

    @PatchMapping("/post/{id}")
    public PostDto updatePost(@PathVariable String id, @RequestBody UpdatePostDto updatePostDto) {
        return postService.updatePost(id, updatePostDto);
    }

    @PatchMapping("/post/{id}/like")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addLike(@PathVariable String id) {
        postService.addLike(id);
    }

    @PatchMapping("/post/{id}/comment/{author}")
    public PostDto addComment(@PathVariable String id, @PathVariable String author, @RequestBody String comment) {
        return postService.addComment(id, author, comment);
    }

    @GetMapping("/post/{id}")
    public PostDto findPostById(@PathVariable String id) {
        return postService.findPostById(id);
    }

    @GetMapping("/posts/author/{author}")
    public List<PostDto> findPostsByAuthor(String author) {
        return postService.findPostsByAuthor(author);
    }

    @GetMapping("/posts/tags")
    public List<PostDto> findPostsByTags(@RequestParam List<String> values) {
        return postService.findPostsByTags(values);
    }

    @GetMapping("/posts/period")
    public List<PostDto> findPostsByPeriod(@RequestParam LocalDateTime dateFrom, @RequestParam LocalDateTime dateTo) {
        return postService.findPostsByPeriod(dateFrom, dateTo);
    }
}
