package forum.risingcreations.controllers;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.models.ProfileComment;
import forum.risingcreations.models.User;
import forum.risingcreations.services.ProfileService;
import forum.risingcreations.services.UserService;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserService userService;


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
    
    @GetMapping("/ownerprofile/{profileid}")
    public String getOwnProfilePage(@PathVariable Long profileid, Model model) {
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

		return "onwerprofile";
	}

	@GetMapping("/profile")
	public String getProfileOrLoginPage(Principal principal, Model model) {
			if (principal!=null) {
			String name = principal.getName();
			if (name!=null) {
				User u = userService.findByUsername(name);
				Profile p = u.getProfile();
				if (p!=null) {
					Long profileid = p.getId();
			        model.addAttribute("profileid", profileid);		       
			        model.addAttribute("profilename", p.getName());
			        model.addAttribute("profiledesc", p.getDescription());
			        model.addAttribute("comments", p.getComments());
					return "ownerprofile";
				}
			}
			}
		return "redirect:/login";
	}
	
	@PostMapping("/profile/changeimg")
	public String changeProfileImage(@RequestParam("img") MultipartFile img,
			Principal principal) {
		if (!img.isEmpty()) {
			byte[] bytes = null;
			try {
				bytes = img.getBytes();
			} catch (IOException e) {
				System.out.println("Can't fetch data from selected image.");
			}
			if (bytes!=null) {
				User u = userService.findByUsername(principal.getName());
				Profile p = u.getProfile();
				p.setImage(bytes);
				profileService.saveProfile(p);
			}
		}
		return "redirect:/profile";
	}
	
	@PostMapping("/profile/changename")
	public String changeName(@RequestParam("name")String name, Principal principal) {
		User u = userService.findByUsername(principal.getName());
		Profile p = u.getProfile();
		p.setName(name);
		profileService.saveProfile(p);
		return "redirect:/profile";
	}

	@PostMapping("/profile/changedesc")
	public String changeDescription(@RequestParam("desc")String desc, Principal principal) {
		User u = userService.findByUsername(principal.getName());
		Profile p = u.getProfile();
		p.setDescription(desc);
		profileService.saveProfile(p);
		return "redirect:/profile";
	}

    @PostMapping("/profile/{profileid}")
    public String postComment(@PathVariable("profileid") Long profileid, @RequestParam("description") String description, Principal principal) {
        if(principal == null)
            return "redirect:/login";

        User u = userService.findByUsername(principal.getName());
        Profile commenter = u.getProfile();

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
