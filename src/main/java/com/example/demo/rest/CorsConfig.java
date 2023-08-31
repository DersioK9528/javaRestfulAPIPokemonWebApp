package com.example.demo.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for handling CORS (Cross-Origin Resource Sharing) configuration.
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configure CORS for specific mappings.
     *
     * @param registry The CORS registry to configure.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/pokemon-api/**") // Allow CORS for this mapping
                .allowedOriginPatterns("*") // Allow requests from any origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specified HTTP methods
                .allowedHeaders("*") // Allow all headers in the request
                .allowCredentials(true) // Allow credentials (cookies, authentication headers)
                .maxAge(3600); // Maximum age of preflight requests in seconds
    }
}
