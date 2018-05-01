package forum.risingcreations.repositories;

import org.springframework.data.repository.CrudRepository;

import forum.risingcreations.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
