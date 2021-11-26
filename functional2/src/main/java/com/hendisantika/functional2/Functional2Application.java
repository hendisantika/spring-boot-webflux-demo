package com.hendisantika.functional2;

import com.hendisantika.functional2.entity.User;
import com.hendisantika.functional2.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Functional2Application {

    public static void main(String[] args) {
        SpringApplication.run(Functional2Application.class, args);
    }

    @Bean
    public CommandLineRunner insertData(UserRepository userMongoRepository) {
        return args -> {
            userMongoRepository.save(new User("Uzumaki", "Kushina")).subscribe();
            userMongoRepository.save(new User("Uchiha", "Madara")).subscribe();
            userMongoRepository.save(new User("Sarutobi", "Hiruzen")).subscribe();
            userMongoRepository.save(new User("Asuma", "Sarutobi")).subscribe();
        };
    }
}
