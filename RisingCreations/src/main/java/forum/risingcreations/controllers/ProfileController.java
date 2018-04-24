package forum.risingcreations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    public static final String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum eros et libero suscipit interdum. Morbi iaculis semper urna, eget mattis elit ornare ut. Ut vel auctor mauris. Sed et scelerisque velit. Suspendisse egestas ligula venenatis orci efficitur, ut tempus nisi porttitor. Fusce dignissim, lectus quis consectetur eleifend, enim elit aliquet tellus, id convallis massa eros porta elit. Donec laoreet euismod dictum. Donec vitae magna ligula.\n" + "In in felis congue, rhoncus lacus lacinia, pulvinar odio. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nam quis tellus molestie, volutpat enim id, dignissim erat. Suspendisse euismod id.";
    public static final String name = "Ola Nordmann";
    public static final String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis pellentesque augue. Praesent vel purus nec tortor lacinia gravida vel sit amet mi. Nulla ornare leo sem, quis cursus orci.";

    @GetMapping("/profile/{profileid}")
    public String getProfilePage(@PathVariable String profileid, Model model) {
        model.addAttribute("profileid", profileid);
        model.addAttribute("profilename", name);
        model.addAttribute("profiledesc", desc);
        model.addAttribute("profilecomment", comment);
        return "profile";
    }

}
