package com.asyncsupport.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ASYNC")
                        .description("Aplicação de usuário ")
                        .version("1.0.1")); // Personalize com o título, descrição e versão da sua API
    }
}