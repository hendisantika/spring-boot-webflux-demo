package com.hendisantika.traditional.resource;

import com.hendisantika.traditional.entity.User;
import com.hendisantika.traditional.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

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

    @GetMapping
    public Mono<ResponseEntity<List<User>>> findAll() {
        return userMongoRepository.findAll()
                .collectList()
                .map(users -> {
                    if (users.isEmpty()) {
                        return ResponseEntity.noContent().build();
                    }
                    return ResponseEntity.ok(users);
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> findById(@PathVariable String id) {
        return userMongoRepository.findById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
