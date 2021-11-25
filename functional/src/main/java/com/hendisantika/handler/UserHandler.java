package com.hendisantika.handler;

import com.hendisantika.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.xml.validation.ValidatorHandler;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/11/21
 * Time: 06.46
 */
@Component
@RequiredArgsConstructor
public class UserHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserHandler.class);

    private final UserRepository userRepository;

    private final ValidatorHandler validatorHandler;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return userRepository.findAll()
                .collectList()
                .flatMap(users -> {
                    if (users.isEmpty()) {
                        return ServerResponse.noContent().build();
                    }
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(users));
                });
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        return userRepository.findById(request.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(user)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
