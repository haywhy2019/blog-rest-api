package com.springboot.blog;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Spring Boot Blog REST API Documentation",
                version = "1.0",
                description = "Spring Boot Documentation for Blog REST API",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Flint",
                        email = "Slimhaywhy@gmail.com",
                        url = "")

        ), servers = {
                @io.swagger.v3.oas.annotations.servers.Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )},
        externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
                description = "Spring Boot Blog REST API Documentation",
                url = "http://localhost:8080/v3/api-docs"
        )
)
public class BlogRestApiApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
	public static void main(String[] args) {
		SpringApplication.run(BlogRestApiApplication.class, args);
	}

}