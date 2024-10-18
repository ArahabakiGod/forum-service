package ait.cohort46.forum.dao;

import ait.cohort46.forum.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public interface ForumRepository extends MongoRepository<Post, String> {
    Stream<Post> findByAuthorIgnoreCase(String author);

    Stream<Post> findByTagsInIgnoreCase(List<String> tags);

    @Query("{'dateCreated': {$gt: ?0, $lt: ?1 }}")
    Stream<Post> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo);
}
