package com.hendisantika.traditional.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
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

    @Override
    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient reactiveMongoClient() {
        var port = env.getProperty("local.mongo.port", Integer.class);
        return MongoClients.create(String.format("mongodb://localhost:%d", port));
    }

    @Bean
    public CommandLineRunner insertData(UserMongoRepository userMongoRepository) {
        return args -> {
            userMongoRepository.save(new User("Uzumaki", "Naruto")).subscribe();
            userMongoRepository.save(new User("Uchiha", "Sasuke")).subscribe();
            userMongoRepository.save(new User("Haruno", "Sakura")).subscribe();
            userMongoRepository.save(new User("Hatake", "Kakashi")).subscribe();
        };
    }
}
