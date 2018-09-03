package forum.risingcreations.auth;

import forum.risingcreations.models.Profile;
import forum.risingcreations.models.User;
import forum.risingcreations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RootUserLoader implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User authUser = new User("admin", new BCryptPasswordEncoder().encode("admin"));
        Profile profile = new Profile();
        profile.setName("Username");
        profile.setDescription("No description yet.");
        authUser.setProfile(profile);
        authUser.setRole("default");
        profile.setUser(authUser);
        userService.saveUser(authUser);
    }
}
