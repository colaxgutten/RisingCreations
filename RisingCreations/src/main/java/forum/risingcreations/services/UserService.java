package forum.risingcreations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.models.User;
import forum.risingcreations.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public void saveUser(User user){
		userRepository.save(user);
	}



}
