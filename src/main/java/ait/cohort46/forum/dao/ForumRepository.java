package ait.cohort46.forum.dao;

import ait.cohort46.forum.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface ForumRepository extends CrudRepository<Post, String> {

}
