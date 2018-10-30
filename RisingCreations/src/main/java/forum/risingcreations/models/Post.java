package forum.risingcreations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime date = LocalDateTime.now();

    @ManyToMany(mappedBy = "likes")
    private Set<Profile> likes = new HashSet<>();

    @ManyToMany(mappedBy = "loves")
    private Set<Profile> loves = new HashSet<>();

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

    public void addLiker(Profile profile) {
        profile.addLikedPost(this);
        likes.add(profile);
    }

    public void addLover(Profile profile) {
        profile.addLovedPost(this);
        loves.add(profile);
    }

    public void removeLiker(Profile profile) {
        profile.removeLikedPost(this);
        likes.remove(profile);
    }

    public void removeLover(Profile profile) {
        profile.removeLovedPost(this);
        loves.remove(profile);
    }

    public Set<Profile> getLikes() { return likes; }

    public Set<Profile> getLoves() { return loves; }
}
