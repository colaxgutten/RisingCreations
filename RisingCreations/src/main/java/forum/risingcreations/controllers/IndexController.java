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
	public String getIndex(@RequestParam(name="name", required=false, defaultValue="World")String name, Model model){
		model.addAttribute("name", name);
//		userService.saveUser(new User(name,"pass"));
//		List<User> users = userService.findByUsername(name);
		Comment comment = new Comment();
		comment.setDescription("This is a descripton");
		Post post = new Post();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comment.setPost(post);
		comments.add(comment);

		post.setComments(comments);
		post.setTitle("Hei");
		postService.save(post);	
		commentService.saveAll(comments);
		Post p = postService.getPostByTitle("Hei");
		System.out.println(p.getComments().size());
		
		return "index";
	}
}
