package forum.risingcreations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import forum.risingcreations.models.LoginForm;
import forum.risingcreations.models.User;
import forum.risingcreations.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String postLoginData(@ModelAttribute LoginForm loginForm) {
        if(loginForm.getUsername() != null && !loginForm.getUsername().isEmpty() && loginForm.getPassword() != null && !loginForm.getPassword().isEmpty()) {
        	User user = userService.authenticatedUser(loginForm.getUsername(), loginForm.getPassword());
        	if (user!=null)
        	return "redirect:/";
        }
        return "redirect:/login";
    }

    
}
