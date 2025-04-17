package dev.fastcleanapi.fastcleanapi.configurations;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Minha API Java com Spring Boot")
                        .version("1.0.0")
                        .description("Documentação gerada automaticamente com Swagger via SpringDoc."));
    }
}