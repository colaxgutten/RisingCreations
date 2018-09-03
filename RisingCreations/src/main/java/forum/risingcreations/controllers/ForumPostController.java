package forum.risingcreations.controllers;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.services.CommentService;
import forum.risingcreations.services.PostService;
import forum.risingcreations.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class ForumPostController {

    @Autowired
    PostService postService;
    @Autowired
    ProfileService profileService;
    @Autowired
    CommentService commentService;

    @GetMapping("/post/{postid}")
    public String getForumPost(@PathVariable("postid") Long postid, Model model) {
        Post p = postService.getById(postid);

        model.addAttribute("post", p);

        return "forumpost";
    }

    @GetMapping(value = "/post/{postid}/img", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getForumPostImage(@PathVariable("postid") Long postid) {
        Post p = postService.getById(postid);
        return p != null ? p.getImage() : new byte[]{};
    }

    @GetMapping("/post")
    public String getCreateForumPost() {
        return "createpost";
    }

    @PostMapping("/post/{postid}")
    public String postComment(@PathVariable("postid") Long postid, @RequestParam("description") String description, Principal principal) {
        Profile profile = profileService.findProfileByName(principal.getName());
        Post post = postService.getById(postid);

        Comment comment = new Comment();
        comment.setProfile(profile);
        comment.setPost(post);
        comment.setDescription(description);
        commentService.save(comment);

        return "redirect:/post/"+postid;
    }

    @PostMapping("/post")
    public @ResponseBody
    String postCreateForumPost(@RequestParam("title") String title,
                               @RequestParam("desc") String description,
                               @RequestParam("img") MultipartFile imageFile,
                               Principal principal) {
        if (!title.isEmpty()) {
            if (!description.isEmpty()) {
                if (!imageFile.isEmpty()) {
                    byte[] bytes = null;

                    try {
                        bytes = imageFile.getBytes();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (bytes != null) {
                        Post post = new Post();
                        post.setImage(bytes);
                        post.setTitle(title);
                        post.setDescription(description);
                        String name = principal.getName();
                        Profile profile = profileService.findProfileByName(name);
                        System.out.println("Profile: " + profile);
                        post.setProfile(profile);
                        System.out.println("Name: "+name);


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
