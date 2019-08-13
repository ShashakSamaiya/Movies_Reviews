package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo")
public class ProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/signin").allowedOrigins("http://localhost:4200");
                registry.addMapping("/signin").allowCredentials(true);
                
                registry.addMapping("/signup").allowedOrigins("http://localhost:4200");
                registry.addMapping("/signup").allowCredentials(true);
                
                registry.addMapping("/signout").allowedOrigins("http://localhost:4200");
                registry.addMapping("/signout").allowCredentials(true);
                
                registry.addMapping("/movie/*").allowedOrigins("http://localhost:4200");
                registry.addMapping("/movie/*").allowCredentials(true);
                
                registry.addMapping("/reviews/*").allowedOrigins("http://localhost:4200");
                registry.addMapping("/reviews/*").allowCredentials(true);
            }
        };
	}
}

