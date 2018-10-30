package forum.risingcreations.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @JsonIgnore
    @OneToOne(mappedBy="profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @JsonIgnore
    @Lob
    private byte[] image;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy="profile", cascade=CascadeType.ALL)
    List<ProfileComment> comments = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy="commenter", fetch=FetchType.LAZY)
    List<ProfileComment> commenter = new ArrayList<>();

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<ProfileComment> getComments() {
        return comments;
    }

    public void addComment(ProfileComment comment) {
        comment.setProfile(this);
        this.comments.add(comment);
    }

    public void addCommenter(ProfileComment comment) {
        comment.setCommenter(this);
        this.commenter.add(comment);
    }

    public void setComments(List<ProfileComment> comments) {
        this.comments = comments;
    }

	public void setId(Long id) {
		this.id = id;
	}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
