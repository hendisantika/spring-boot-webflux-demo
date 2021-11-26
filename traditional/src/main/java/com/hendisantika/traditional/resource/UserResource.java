package com.hendisantika.traditional.resource;

import com.hendisantika.traditional.entity.User;
import com.hendisantika.traditional.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
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

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Mono<ResponseEntity<User>> save(@Valid @RequestBody User user) {
        return userMongoRepository.save(user)
                .map(userSaved -> UriComponentsBuilder.fromPath(("/{id}")).buildAndExpand(userSaved.getId()).toUri())
                .map(uri -> ResponseEntity.created(uri).build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
//        userMongoRepository.deleteById(id); //does not work because it is not part of a chain, so it is not
//        subscribed by any method
        //nothing happens if you don't subscribe
        userMongoRepository.deleteById(id).subscribe();
    }
}
