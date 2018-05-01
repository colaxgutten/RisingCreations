package forum.risingcreations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.Post;
import forum.risingcreations.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public Iterable<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public Post getById(long id) {
		return postRepository.findById(id).orElse(null);
	}

	public void delete(Post post) {	postRepository.delete(post); }

	public void save(Post post) {
		postRepository.save(post);	
	}
	
	public Post getPostByTitle(String title){
		for (Post post : postRepository.findAll()){
			if (post.getTitle().equals(title))
				return post;
		}
		return null;
	}
	
	

}
