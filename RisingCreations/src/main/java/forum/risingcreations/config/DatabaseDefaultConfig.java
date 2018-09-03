package forum.risingcreations.config;

import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.models.User;
import forum.risingcreations.services.PostService;
import forum.risingcreations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;

@Component
public class DatabaseDefaultConfig implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Autowired
    PostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Create a default user with username admin and password admin
        User authUser = new User("admin", new BCryptPasswordEncoder().encode("admin"));
        Profile profile = new Profile();
        profile.setName("Username");
        profile.setDescription("No description yet.");
        authUser.setProfile(profile);
        authUser.setRole("default");
        profile.setUser(authUser);
        userService.saveUser(authUser);

        // Create a default post
        Post post = new Post();
        post.setImage(Base64.getDecoder().decode(getPicture().getBytes()));
        post.setTitle("post title");
        post.setDescription("post description");
        post.setProfile(profile);

        postService.save(post);
    }

    private String getPicture() {
        return "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";
    }
}