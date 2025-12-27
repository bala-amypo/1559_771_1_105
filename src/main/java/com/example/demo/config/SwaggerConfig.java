package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth"; // Define the scheme name [cite: 441]
        
        return new OpenAPI()
                .info(new Info()
                        .title("Digital Visitor Management API")
                        .version("1.0")
                        .description("API for managing visitors, hosts, and appointments with JWT security."))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)) // Apply globally [cite: 431]
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP) // HTTP Type [cite: 441]
                                        .scheme("bearer") // Bearer scheme [cite: 441]
                                        .bearerFormat("JWT"))); // JWT format [cite: 441]
    }
}