package forum.risingcreations.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String getRegisterPage() {  	
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterData(@ModelAttribute LoginForm loginForm) {
    	if(loginForm.getUsername() != null && !loginForm.getUsername().isEmpty() && loginForm.getPassword() != null && !loginForm.getPassword().isEmpty()) {
    		User user = userService.findByUsername(loginForm.getUsername());
    		System.out.println(user);
    		if (user!=null)
    			return "/register";
    		System.out.println("user doesnt exist");
    		User authUser = new User(loginForm.getUsername(),passwordEncoder.encode(loginForm.getPassword()));
    		Profile profile = new Profile();
    		profile.setName("Username");
    		profile.setDescription("No description yet.");
    		authUser.setProfile(profile);
    		authUser.setRole("default");
    		profile.setUser(authUser);
    		userService.saveUser(authUser);
    		return "redirect:/login";
    	}
		System.out.println("whyyyy?");

    		return "/register";
    }
}
