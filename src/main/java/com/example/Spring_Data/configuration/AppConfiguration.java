package com.example.Spring_Data.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Podvorchan Ruslan 27.01.2023
 */
@Configuration
public class AppConfiguration {
    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
