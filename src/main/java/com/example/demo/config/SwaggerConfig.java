package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Digital Visitor Management API")
                        .description("API for managing visitors, users and appointments")
                        .version("1.0.0")
                )

                // 🔐 JWT Security
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()

                        // 🔐 Security Scheme
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )

                        // 📦 SCHEMAS (THIS FIXES YOUR ERROR)
                        .addSchemas("Visitor", new Schema<>().type("object"))
                        .addSchemas("User", new Schema<>().type("object"))
                        .addSchemas("Appointment", new Schema<>().type("object"))
                        .addSchemas("ApiResponse", new Schema<>().type("object"))
                );
    }
}
