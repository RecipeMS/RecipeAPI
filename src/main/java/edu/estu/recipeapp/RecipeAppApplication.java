package edu.estu.recipeapp;

import edu.estu.recipeapp.utils.DataUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecipeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipeAppApplication.class, args);
    }

    // Command line runner is a Spring Boot feature that allows us to run some code when the application starts.
    @Bean
    public CommandLineRunner runner() {
        return args -> {
            DataUtils.initializeRecords();
        };
    }
}