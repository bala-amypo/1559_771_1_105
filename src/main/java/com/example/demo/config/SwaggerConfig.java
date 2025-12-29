package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SwaggerConfig {

    @Bean
    @Primary // Ensures Spring uses this bean when multiple OpenAPI beans exist
    public OpenAPI swaggerOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Digital Visitor Management API")
                        .version("1.0")
                        .description("Swagger documentation for Visitor Management")
                )
                // Apply JWT security globally
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                        // Example schemas for Swagger UI
                        .addSchemas("Visitor", new Schema<>().type("object"))
                        .addSchemas("User", new Schema<>().type("object"))
                        .addSchemas("Appointment", new Schema<>().type("object"))
                        .addSchemas("ApiResponse", new Schema<>().type("object"))
                );
    }
}
