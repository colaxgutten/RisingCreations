package forum.risingcreations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private List<Tag> tags = new ArrayList<>();
    
    @ManyToOne(targetEntity = Profile.class)
    @JoinColumn(name = "profile")
    private Profile profile;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();

    private String title;
    private String description;
    private LocalDateTime date = LocalDateTime.now();

    @JsonIgnore
    @Lob
    private byte[] image;

    public void addComment(Comment comment) {
        comment.setPost(this);
        this.comments.add(comment);
    }

    public Long getId() {
        return id;
    }
    
    public List<Tag> getTags(){
    	return tags;
    }
    
    public void setTags(List<Tag> tags) {
    	this.tags=tags;
    }
    
    public void addTag(Tag t) {
    	tags.add(t);
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

    public LocalDateTime getDate() { return this.date; }

    public void setDate(LocalDateTime date) { this.date = date; }

    public String getFormattedDate() {
        return this.date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
    }

}
