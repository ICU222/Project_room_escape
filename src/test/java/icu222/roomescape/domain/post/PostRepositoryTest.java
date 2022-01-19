package icu222.roomescape.domain.post;

// https://deviscreen.tistory.com/99
// after 대신 이거를 사용
import icu222.roomescape.domain.posts.PostRepository;
import icu222.roomescape.domain.posts.Posts;
import icu222.roomescape.web.testController;
import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;

// 해당 패키지는 책의 .runner.Runwith 대신 사용
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = testController.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void retrieve_savePost(){
        // given
        String title = "Test Post";
        String content = "> content goes here <";

        // 이 구조 책에 있었는데 >> 93p
        postsRepository.save(Posts.builder().
                title(title)
                .content(content)
                .author("icu222")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }
}
