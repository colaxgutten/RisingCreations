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
	
	public User findByUsername(String username){
		for (User s : userRepository.findAll()) {
			if (s.getUsername().equals(username)) {
				return s;
			}
		}
		return null;
	}
	
	public User authenticatedUser(String username, String password) {
		for (User s : userRepository.findAll()) {
			if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
				return s;
			}
		}
		return null;
	}
	
	public void saveUser(User user){
		userRepository.save(user);
	}



}
