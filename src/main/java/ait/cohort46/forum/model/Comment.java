package ait.cohort46.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Comment {
    private String user;
    private String message;
    private LocalDateTime dateCreated;
    private Long likes;
}
