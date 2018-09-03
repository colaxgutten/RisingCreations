package forum.risingcreations.auth;

import forum.risingcreations.models.Profile;
import forum.risingcreations.models.User;
import forum.risingcreations.services.ProfileService;
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
    
    @Autowired
    private ProfileService profileService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User authUser = new User("admin", new BCryptPasswordEncoder().encode("admin"));
        Profile profile = new Profile();
        profile.setName(authUser.getUsername());
        profile.setDescription("No description yet.");
        authUser.setProfile(profile);
        authUser.setRole("default");
        profile.setUser(authUser);
        profileService.saveProfile(profile);
        userService.saveUser(authUser);
    }
}
