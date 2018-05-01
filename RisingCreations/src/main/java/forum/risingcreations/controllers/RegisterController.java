package forum.risingcreations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import forum.risingcreations.models.Post;
import forum.risingcreations.services.PostService;

@Controller
public class RegisterController {
	@Autowired
	private PostService postService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterData() {
        return null;
    }
}
