package dev.fastcleanapi.fastcleanapi.configurations;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
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
                        .title("Fastclean API")
                        .version("1.0.0")
                        .description("Documentação dos endpoints da Fastclean API, oferecendo recursos para limpeza eficiente e rápida.")
                        .termsOfService("http://fastcleanapi.com/terms")
                        .contact(new Contact()
                                .name("Equipe Fastclean")
                                .email("contato@fastcleanapi.com")
                                .url("http://fastcleanapi.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("http://opensource.org/licenses/MIT"))
                );
    }
}
