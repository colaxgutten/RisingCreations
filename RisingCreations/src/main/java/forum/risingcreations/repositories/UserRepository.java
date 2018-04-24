package forum.risingcreations.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import forum.risingcreations.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByUsername(String username);
}
