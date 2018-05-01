package forum.risingcreations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForumPostController {

    private final String title = "Lorem ipsum dolor sit amet";
    private final String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur dui in dolor porttitor, quis tincidunt arcu semper. Integer hendrerit tempor nisi, in pulvinar nibh. Cras malesuada gravida blandit. Nullam mattis nibh dui, sed placerat nulla luctus ac. Curabitur accumsan, ante nec gravida volutpat, turpis ipsum ultricies tortor, quis ultrices.";
    private final String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis pellentesque augue. Praesent vel purus nec tortor lacinia gravida vel sit amet mi. Nulla ornare leo sem, quis cursus orci.";
    private final String commentname = "Kari Nordmann";
    private final String commentdate = "March 10, 2018";

    @GetMapping("/post/{postid}")
    public String getForumPost(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("comment", comment);
        model.addAttribute("commentname", commentname);
        model.addAttribute("commentdate", commentdate);

        return "forumpost";
    }
}
