package forum.risingcreations.repositories;

import org.springframework.data.repository.CrudRepository;

import forum.risingcreations.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
