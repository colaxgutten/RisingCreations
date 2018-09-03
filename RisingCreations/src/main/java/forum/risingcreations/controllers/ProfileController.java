package forum.risingcreations.controllers;

import forum.risingcreations.models.Profile;
import forum.risingcreations.services.ProfileService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

	@Autowired
	ProfileService profileService;

	public static final String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum eros et libero suscipit interdum. Morbi iaculis semper urna, eget mattis elit ornare ut. Ut vel auctor mauris. Sed et scelerisque velit. Suspendisse egestas ligula venenatis orci efficitur, ut tempus nisi porttitor. Fusce dignissim, lectus quis consectetur eleifend, enim elit aliquet tellus, id convallis massa eros porta elit. Donec laoreet euismod dictum. Donec vitae magna ligula.\n"
			+ "In in felis congue, rhoncus lacus lacinia, pulvinar odio. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nam quis tellus molestie, volutpat enim id, dignissim erat. Suspendisse euismod id.";
	public static final String name = "Ola Nordmann";

	@GetMapping("/profile/{profileid}")
	public String getProfilePage(@PathVariable String profileid, Model model) {
		Profile profile = null;

		if (profileid != null && !profileid.isEmpty()) {
			Long profileidParsed = null;

			try {
				profileidParsed = Long.parseLong(profileid);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if (profileidParsed != null) {
				profile = profileService.findProfileById(profileidParsed);
			}
		}

		model.addAttribute("profileid", profileid);
		model.addAttribute("profilename", name);
		model.addAttribute("profiledesc", desc);

		if (profile != null) {
			model.addAttribute("profilename", profile.getName());
			model.addAttribute("profiledesc", profile.getDescription());
		}

		return "profile";
	}

	@GetMapping("/profile")
	public String getProfileOrLoginPage(Principal principal) {
			if (principal!=null) {
			String name = principal.getName();
			if (name!=null) {
				Profile p = profileService.findProfileByName(name);
				if (p!=null)
					return "/profile/"+p.getId();
			}
			}
		return "/login";
	}

}
