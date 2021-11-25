package com.hendisantika.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/11/21
 * Time: 06.43
 */
@Document
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    @NotBlank
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
