package forum.risingcreations.controllers;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.models.Profile;
import forum.risingcreations.models.Tag;
import forum.risingcreations.models.User;
import forum.risingcreations.services.CommentService;
import forum.risingcreations.services.PostService;
import forum.risingcreations.services.ProfileService;
import forum.risingcreations.services.TagService;
import forum.risingcreations.services.UserService;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class ForumPostController {

    @Autowired
    PostService postService;
    @Autowired
    ProfileService profileService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    TagService tagService;

    @GetMapping("/post/{postid}")
    public String getForumPost(@PathVariable("postid") Long postid, Model model, Principal principal) {
        User u = userService.findByUsername(principal.getName());
        Profile profile = u.getProfile();
        Post p = postService.getById(postid);

        model.addAttribute("comments", p.getComments());
        model.addAttribute("post", p);

        model.addAttribute("liked", profile.getLikes().contains(p));
        model.addAttribute("loved", profile.getLoves().contains(p));

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
        User u = userService.findByUsername(principal.getName());
    	Profile profile = u.getProfile();
        Post post = postService.getById(postid);

        Comment comment = new Comment();
        comment.setProfile(profile);
        comment.setPost(post);
        comment.setDescription(description);
        commentService.save(comment);

        return "redirect:/post/"+postid;
    }

    @PostMapping("/post/{postid}/like")
    public @ResponseBody
    Pair<Integer, Boolean> likePost(@PathVariable("postid") Long postid, Principal principal) {
        User u = userService.findByUsername(principal.getName());
        Profile profile = u.getProfile();
        Post post = postService.getById(postid);

        boolean liked = post.getLikes().contains(profile);

        if (liked) {
            post.removeLiker(profile);
        } else {
            post.addLiker(profile);
        }
        postService.save(post);

        return new Pair<>(post.getLikes().size(), !liked);
    }

    @PostMapping("/post/{postid}/love")
    public @ResponseBody
    Pair<Integer, Boolean> lovePost(@PathVariable("postid") Long postid, Principal principal) {
        User u = userService.findByUsername(principal.getName());
        Profile profile = u.getProfile();
        Post post = postService.getById(postid);

        boolean loved = post.getLoves().contains(profile);

        if (loved) {
            post.removeLover(profile);
        } else {
            post.addLover(profile);
        }
        postService.save(post);

        return new Pair<>(post.getLoves().size(), !loved);
    }

    @PostMapping("/post")
    public @ResponseBody
    String postCreateForumPost(@RequestParam("title") String title,
                               @RequestParam("desc") String description,
                               @RequestParam("img") MultipartFile imageFile,
                               @RequestParam("tag") String tagName,
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
                    	User u = userService.findByUsername(principal.getName());
                        Post post = new Post();
                        post.setImage(bytes);
                        post.setTitle(title);
                        post.setDescription(description);
                        if (tagName!=null && tagName.length()>0) {
                        	Tag t = tagService.getTagByName(tagName);
                        	post.addTag(t);
                        }
                        String name = principal.getName();
                        Profile profile = u.getProfile();
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
