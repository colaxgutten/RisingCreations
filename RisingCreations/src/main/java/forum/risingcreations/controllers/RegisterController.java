package forum.risingcreations.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import forum.risingcreations.models.LoginForm;
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
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterData(@ModelAttribute LoginForm loginForm) {
    	if(loginForm.getUsername() != null && !loginForm.getUsername().isEmpty() && loginForm.getPassword() != null && !loginForm.getPassword().isEmpty()) {
    		User user = userService.findByUsername(loginForm.getUsername());
    		if (user==null)
    			return "/register";
    		User authUser = new User(loginForm.getUsername(),loginForm.getPassword());
    		Profile profile = new Profile();
    		profile.setName("Username");
    		profile.setDescription("No description yet.");
    		user.setProfile(profile);
    		profile.setUser(user);
    		userService.saveUser(user);
    		return "redirect:/login";
    	}
    		return "/register";
    }
}
