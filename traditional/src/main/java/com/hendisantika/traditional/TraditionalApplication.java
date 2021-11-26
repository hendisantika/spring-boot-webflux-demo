package com.hendisantika.traditional;

import com.hendisantika.traditional.entity.User;
import com.hendisantika.traditional.repository.UserMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TraditionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraditionalApplication.class, args);
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
