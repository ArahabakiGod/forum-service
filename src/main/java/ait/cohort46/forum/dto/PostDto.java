package ait.cohort46.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    private List<String> tags;
    private Long likes;
    private List<String> comments;
}
