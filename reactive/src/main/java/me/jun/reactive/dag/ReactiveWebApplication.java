package me.jun.reactive.dag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ReactiveWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebApplication.class, args);
    }
}
