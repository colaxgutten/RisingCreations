package forum.risingcreations.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
public class ProfileComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "commenter_id")
    private Profile commenter;

    public void setId(Long id) {
        this.id = id;
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

    public Profile getCommenter() {
        return commenter;
    }

    public void setCommenter(Profile commenter) {
        this.commenter = commenter;
    }

    public LocalDateTime getDate() { return this.date; }

    public void setDate(LocalDateTime date) { this.date = date; }

    public String getFormattedDate() {
        return this.date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
    }
}
