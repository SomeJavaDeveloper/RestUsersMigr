package ru.users.restusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"ru.users.restusers"})
public class RestUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestUsersApplication.class, args);
    }

}
