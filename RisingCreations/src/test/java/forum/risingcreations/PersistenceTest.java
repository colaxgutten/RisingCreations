package forum.risingcreations;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.repositories.PostRepository;
import forum.risingcreations.services.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@TestPropertySource("/testapplication.properties")
@ExtendWith(SpringExtension.class)
class PersistenceTest {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    public void savingPostWillResultInOneEntity() {
        Post post = new Post();
        post.setTitle("1");

        postService.save(post);

        Iterable<Post> iterable = postService.getAllPosts();
        assertTrue(iterable.iterator().hasNext());

        postService.delete(post);
    }

    @Test
    public void savingPostPersistsComment() {
        Post post = new Post();
        post.setTitle("2");

        Comment comment = new Comment();
        comment.setDescription("This is a description");

        post.addComment(comment);

        postService.save(post);

        Post p = postService.getById(post.getId());
        assertTrue(p != null);
        assertEquals(1, p.getComments().size());

        postService.delete(p);
    }
}
