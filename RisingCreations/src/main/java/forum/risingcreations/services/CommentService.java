package forum.risingcreations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.Comment;
import forum.risingcreations.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public void save(Comment comment){
		commentRepository.save(comment);
	}
	
	public void saveAll(List<Comment> comments){
		commentRepository.saveAll(comments);
	}
	
	public Comment getCommentByDescription(String description){
		for (Comment c : commentRepository.findAll()){
			if (c.getDescription().equals(description))
				return c;
		}
		return null;
	}
}
