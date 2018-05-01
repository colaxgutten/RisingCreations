package forum.risingcreations.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity=Profile.class)
	@JoinColumn(name = "profile")
	private Profile profile;
	
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL)
	List<Comment> comments = new ArrayList<Comment>();

	private String title;
	private String description;
	private byte[] image;

	public void addComment(Comment comment) {
		comment.setPost(this);
		this.comments.add(comment);
	}
	
	public Long getId() {
		return id;
	}
	public Profile getProfile() {
		return profile;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
