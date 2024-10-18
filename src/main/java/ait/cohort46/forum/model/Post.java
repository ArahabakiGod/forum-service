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
    private String id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String author;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private List<String> tags;
    @Setter
    private long likes;
    private List<Comment> comments = new ArrayList<>();

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

    public void addLike() {
        likes++;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }
}
