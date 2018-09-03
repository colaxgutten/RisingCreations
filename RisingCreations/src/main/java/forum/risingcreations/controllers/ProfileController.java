package forum.risingcreations.controllers;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.models.ProfileComment;
import forum.risingcreations.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping(value = "/profile/{profileid}/img", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getForumPostImage(@PathVariable Long profileid) {
        Profile p = profileService.findProfileById(profileid);
        return p != null ? p.getImage() : new byte[]{};
    }

    @GetMapping("/profile/{profileid}")
    public String getProfilePage(@PathVariable Long profileid, Model model) {
        Profile profile = null;

        if (profileid != null) {
            profile = profileService.findProfileById(profileid);
        }

        model.addAttribute("profileid", profileid);

        if (profile != null) {
            model.addAttribute("profilename", profile.getName());
            model.addAttribute("profiledesc", profile.getDescription());
            model.addAttribute("comments", profile.getComments());
        }

        return "profile";
    }

    @PostMapping("/profile/{profileid}")
    public String postComment(@PathVariable("profileid") Long profileid, @RequestParam("description") String description, Principal principal) {
        if(principal == null)
            return "redirect:/login";

        Profile commenter = profileService.findProfileByName(principal.getName());

        Profile profile = profileService.findProfileById(profileid);

        ProfileComment comment = new ProfileComment();
        comment.setCommenter(commenter);
        comment.setDescription(description);

        profile.addComment(comment);
        // commenter.addCommenter(comment);

        profileService.saveProfile(profile);

        return "redirect:/profile/" + profileid;
    }

}
