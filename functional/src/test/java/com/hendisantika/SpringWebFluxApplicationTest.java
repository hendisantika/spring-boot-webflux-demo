package com.hendisantika;

import com.hendisantika.entity.User;
import com.hendisantika.handler.UserHandler;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.router.UserRouter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/11/21
 * Time: 06.52
 */
@SpringBootTest
class SpringWebFluxApplicationTests {

    @Autowired
    private UserRouter userRouter;

    @Autowired
    private UserHandler userHandler;

    @MockBean
    private UserRepository userMongoRepository;

    @Test
    public void findAllTest() {
        WebTestClient client = WebTestClient
                .bindToRouterFunction(userRouter.findAllRouter(userHandler))
                .build();

        List<User> users = Arrays.asList(new User("Valentino", "Rossi"),
                new User("Filippo", "Inzaghi"));

        Flux<User> flux = Flux.fromIterable(users);
        given(userMongoRepository.findAll())
                .willReturn(flux);

        client.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .isEqualTo(users);
    }
}
