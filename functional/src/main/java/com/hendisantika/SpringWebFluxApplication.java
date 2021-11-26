package com.hendisantika;

import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/11/21
 * Time: 06.40
 */
@SpringBootApplication
public class SpringWebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxApplication.class);
    }

    @Bean
    public CommandLineRunner insertData(UserRepository userMongoRepository) {
        return args -> {
            userMongoRepository.save(new User("Uzumaki", "Kushina")).subscribe();
            userMongoRepository.save(new User("Uchiha", "madara")).subscribe();
            userMongoRepository.save(new User("Sarutobi", "Hiruzen")).subscribe();
            userMongoRepository.save(new User("Asuma", "Sarutobi")).subscribe();
        };
    }
}
