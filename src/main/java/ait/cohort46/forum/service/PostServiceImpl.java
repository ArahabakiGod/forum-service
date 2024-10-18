package ait.cohort46.forum.service;

import ait.cohort46.forum.dao.ForumRepository;
import ait.cohort46.forum.dto.*;
import ait.cohort46.forum.dto.exceptions.PostNotFoundException;
import ait.cohort46.forum.model.Comment;
import ait.cohort46.forum.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final ForumRepository forumRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto addPost(String author, AddPostDto addPostDto) {
        Post post = modelMapper.map(addPostDto, Post.class);
        post.setAuthor(author);
        forumRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto deletePost(String id) {
        Post post = forumRepository.findById(id).orElseThrow(PostNotFoundException::new);
        forumRepository.deleteById(id);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto updatePost(String id, UpdatePostDto updatePostDto) {
        Post post = forumRepository.findById(id).orElseThrow(PostNotFoundException::new);
        if (updatePostDto.getTitle() != null) {
            post.setTitle(updatePostDto.getTitle());
        }
        if (updatePostDto.getContent() != null) {
            post.setContent(updatePostDto.getContent());
        }
        if (updatePostDto.getTags() != null) {
            post.getTags().addAll(updatePostDto.getTags());
        }
        forumRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void addLike(String id) {
        Post post = forumRepository.findById(id).orElseThrow(PostNotFoundException::new);
        post.addLike();
        forumRepository.save(post);
    }

    @Override
    public PostDto addComment(String id, String author, NewCommentDto comment) {
        Post post = forumRepository.findById(id).orElseThrow(PostNotFoundException::new);
        Comment newComment = new Comment(author, comment.getMessage());
        post.addComment(newComment);
        forumRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto findPostById(String id) {
        Post post = forumRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return forumRepository.findByAuthorIgnoreCase(author)
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public List<PostDto> findPostsByTags(List<String> tags) {
        return forumRepository.findByTagsInIgnoreCase(tags)
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public List<PostDto> findPostsByPeriod(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return forumRepository.findByDate(dateFrom, dateTo)
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }
}
