package com.darpan.quizzapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Quiz App API",
                version = "1.0",
                description = "API Documentation for the Quiz Application",
                contact = @Contact(
                        name = "Darpan Pandey",
                        email = "pdarpan22@tbc.edu.np"
                )
        ),
        servers = @Server(url = "http://localhost:8080",description = "Local Server")
)
public class OpenAPIConfiguration {

}
