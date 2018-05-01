package forum.risingcreations.models;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;
    
    @ManyToOne (targetEntity=Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Post getPost() {
		return post;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
