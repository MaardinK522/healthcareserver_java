package com.mkproductions.healthcareserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HealthCareServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCareServerApplication.class, args);
    }
}


