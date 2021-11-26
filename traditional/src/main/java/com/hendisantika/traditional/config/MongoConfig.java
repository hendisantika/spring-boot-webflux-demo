package com.hendisantika.traditional.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/11/21
 * Time: 05.57
 */
@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    private final Environment env;

    @Override
    protected String getDatabaseName() {
        return "users";
    }
}
