package com.hendisantika.router;

import com.hendisantika.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/11/21
 * Time: 06.45
 */
@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> findAllRouter(UserHandler userHandler) {
        return route(GET("/users")
                .and(accept(MediaType.APPLICATION_JSON)), userHandler::findAll);
    }

    @Bean
    public RouterFunction<ServerResponse> findById(UserHandler userHandler) {
        return route(GET("/users/{id}")
                .and(accept(MediaType.APPLICATION_JSON)), userHandler::findById);
    }

    @Bean
    public RouterFunction<ServerResponse> save(UserHandler userHandler) {
        return route(POST("/users")
                .or(PUT("/users"))
                .and(accept(MediaType.APPLICATION_JSON)), userHandler::save);
    }

    @Bean
    public RouterFunction<ServerResponse> delete(UserHandler userHandler) {
        return route(DELETE("/users/{id}")
                .and(accept(MediaType.APPLICATION_JSON)), userHandler::delete);
    }
}
