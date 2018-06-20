package com.tul.ta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class TripAdvisorApp {

    public static void main(String[] args) {
        SpringApplication.run(TripAdvisorApp.class, args);
    }
}
