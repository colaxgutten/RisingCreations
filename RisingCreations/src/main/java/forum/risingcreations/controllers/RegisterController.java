package forum.risingcreations.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.models.User;
import forum.risingcreations.services.PostService;
import forum.risingcreations.services.ProfileService;
import forum.risingcreations.services.UserService;

@Controller
public class RegisterController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage() {
    	Profile profile = new Profile();
    	profile.setName("Hei");
    	User user = new User("Daniel","Hei");
    	profile.setUser(user);
    	user.setProfile(profile);
    	userService.saveUser(user);
    	List<User> list = userService.findByUsername("Daniel");
    	for (User users : list) {
    		System.out.println(users.getProfile().getName());
    	}
    	
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterData() {
        return null;
    }
}
