package ait.cohort46.forum.service;

import ait.cohort46.forum.dao.ForumRepository;
import ait.cohort46.forum.dto.AddPostDto;
import ait.cohort46.forum.dto.PostDto;
import ait.cohort46.forum.dto.UpdatePostDto;
import ait.cohort46.forum.dto.exceptions.PostNotFoundException;
import ait.cohort46.forum.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final ForumRepository forumRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto addPost(String author, AddPostDto addPostDto) {
        Post post = modelMapper.map(addPostDto, Post.class);
        post.setAuthor(author);
        post = forumRepository.save(post);
        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    @Override
    public PostDto deletePost(String id) {
        return null;
    }

    @Override
    public PostDto updatePost(String id, UpdatePostDto updatePostDto) {
        return null;
    }

    @Override
    public void addLike(String id) {

    }

    @Override
    public PostDto addComment(String id, String author, String comment) {
        return null;
    }

    @Override
    public PostDto findPostById(String id) {
        Post post = forumRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return List.of();
    }

    @Override
    public List<PostDto> findPostsByTags(List<String> tags) {
        return List.of();
    }

    @Override
    public List<PostDto> findPostsByPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return List.of();
    }
}
