package forum.risingcreations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.Post;
import forum.risingcreations.models.Tag;
import forum.risingcreations.repositories.PostRepository;
import forum.risingcreations.repositories.TagRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	@Autowired
	TagService tagService;

	public Iterable<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public List<Post> getAllPostsAsList() {
		return postRepository.findAll();
	}

	public List<Long> getAllPostsAsIdList() {
		return postRepository.findAllAsIdList();
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
	
	public List<Post> getPostsByTag(List<Tag> tags) {
		ArrayList<Post> posts = new ArrayList<Post>();
		if (posts!= null) {
		for (Tag t : tags) {
			List<Post> tempPosts = postRepository.findByTags_TagName(t.getTagName());
			if (tempPosts!=null) {
				posts.addAll(tempPosts);
			}
		}
		HashSet<Post> hs = new HashSet();
		hs.addAll(posts);
		posts.clear();
		posts.addAll(hs);
			}
		return posts;
	}
}
