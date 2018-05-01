package forum.risingcreations.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.models.User;
import forum.risingcreations.services.CommentService;
import forum.risingcreations.services.PostService;
import forum.risingcreations.services.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/")
	public String getIndex(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
		List<Post> postList = postService.getAllPostsAsList();

		model.addAttribute("name", name);
		model.addAttribute("posts", postList);

		return "index";
	}
}
