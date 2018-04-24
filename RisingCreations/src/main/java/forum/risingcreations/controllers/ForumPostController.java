package forum.risingcreations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForumPostController {

    @GetMapping("/post/{postid}")
    public String getForumPost() {
        return "forumpost";
    }
}
