package com.example.demo.config;

import io.swagger.v3.oas.models.*;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .info(new Info()
                .title("Visitor Management API")
                .version("1.0")
                .description("API documentation"));
    }
}
