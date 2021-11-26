package com.hendisantika.traditional.resource;

import com.hendisantika.traditional.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/11/21
 * Time: 06.02
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserMongoRepository userMongoRepository;

}
