package forum.risingcreations.controllers;

import forum.risingcreations.models.Post;
import forum.risingcreations.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ForumPostController {

    private final String title = "Lorem ipsum dolor sit amet";
    private final String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur dui in dolor porttitor, quis tincidunt arcu semper. Integer hendrerit tempor nisi, in pulvinar nibh. Cras malesuada gravida blandit. Nullam mattis nibh dui, sed placerat nulla luctus ac. Curabitur accumsan, ante nec gravida volutpat, turpis ipsum ultricies tortor, quis ultrices.";
    private final String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis pellentesque augue. Praesent vel purus nec tortor lacinia gravida vel sit amet mi. Nulla ornare leo sem, quis cursus orci.";
    private final String commentname = "Kari Nordmann";
    private final String commentdate = "March 10, 2018";

    @Autowired
    PostService postService;

    @GetMapping("/post/{postid}")
    public String getForumPost(Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("comment", comment);
        model.addAttribute("commentname", commentname);
        model.addAttribute("commentdate", commentdate);

        return "forumpost";
    }

    @GetMapping( value = "/post/{postid}/img", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getForumPostImage(@PathVariable("postid") Long postid) {
        Post p = postService.getById(postid);
        return p != null ? p.getImage() : new byte[]{};
    }

    @GetMapping("/post")
    public String getCreateForumPost() {
        return "createpost";
    }

    @PostMapping("/post")
    public @ResponseBody String postCreateForumPost(@RequestParam("title") String title,
                                                    @RequestParam("desc") String description,
                                                    @RequestParam("img") MultipartFile imageFile) {
        if(!title.isEmpty()) {
            if(!description.isEmpty()) {
                if(!imageFile.isEmpty()) {
                    byte[] bytes = null;

                    try {
                        bytes = imageFile.getBytes();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(bytes != null) {
                        Post post = new Post();
                        post.setImage(bytes);
                        post.setTitle(title);
                        post.setDescription(description);

                        postService.save(post);
                    }

                    return "Success!";
                } else {
                    return "You failed to upload " + title
                            + " because the file was empty.";
                }
            } else {
                return "Failed to upload because description was empty.";
            }
        } else {
            return "Failed to upload because title was empty.";
        }
    }
}
