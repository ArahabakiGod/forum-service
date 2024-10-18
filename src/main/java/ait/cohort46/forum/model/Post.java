package ait.cohort46.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Document(collection = "posts")
@NoArgsConstructor
public class Post {
    @Id
    private String id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String author;
    private LocalDateTime dateCreated;
    private List<String> tags;
    @Setter
    private Long likes;
    private List<Comment> comments;

    public Post(String id, String title, String content, String author, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = tags;
        likes = 0L;
        comments = new ArrayList<>();
        dateCreated = LocalDateTime.now();
    }

    public Post(String id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        likes = 0L;
        comments = new ArrayList<>();
        tags = new ArrayList<>();
        dateCreated = LocalDateTime.now();
    }
}
