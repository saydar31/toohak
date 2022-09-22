package ru.itis.kahootflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Application {

    @Bean
    public Random random(){
        return new Random(42);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
