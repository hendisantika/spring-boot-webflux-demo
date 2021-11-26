package com.hendisantika.traditional.repository;

import com.hendisantika.traditional.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/11/21
 * Time: 06.01
 */
public interface UserMongoRepository extends ReactiveMongoRepository<User, String> {
}
