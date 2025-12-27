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
    public OpenAPI visitorManagementOpenAPI() {
        // Define the Security Scheme Name
        final String securitySchemeName = "bearerAuth"; [cite: 441]

        return new OpenAPI()
                .info(new Info()
                        .title("Digital Visitor Management API") [cite: 423]
                        .version("1.0")
                        .description("API for managing visitors, hosts, and appointments with JWT security.")) [cite: 443]
                // Apply the security requirement globally to all protected endpoints
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)) [cite: 431]
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP) [cite: 441]
                                        .scheme("bearer") [cite: 441]
                                        .bearerFormat("JWT"))); [cite: 441]
    }
}