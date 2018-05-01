package forum.risingcreations;

import forum.risingcreations.models.Comment;
import forum.risingcreations.models.Post;
import forum.risingcreations.services.CommentService;
import forum.risingcreations.services.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class PersistenceTest {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Test
    private void testThePersistence() {
        Post post = new Post();
        post.setTitle("Hei");

        Comment comment = new Comment();
        comment.setDescription("This is a description");

        post.addComment(comment);

        postService.save(post);

        Post p = postService.getPostByTitle("Hei");
        System.out.println("p(" + p + "), p.getComments(" + p.getComments() + "), p.getComments().size(" + p.getComments().size() + ")");
    }
}
