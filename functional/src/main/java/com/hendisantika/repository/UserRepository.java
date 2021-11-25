package com.hendisantika.repository;

import com.hendisantika.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/11/21
 * Time: 06.44
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
