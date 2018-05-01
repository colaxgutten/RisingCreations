package forum.risingcreations.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import forum.risingcreations.models.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAll();

    @Query("SELECT p.id FROM Post p")
    List<Long> findAllAsIdList();

}
