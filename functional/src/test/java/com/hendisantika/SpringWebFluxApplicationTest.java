package com.hendisantika;

import com.hendisantika.handler.UserHandler;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.router.UserRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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


}
