package dev.fastcleanapi.fastcleanapi.configurations;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

@Component
public class SwaggerAutoOpener {

    @PostConstruct
    public void openSwaggerUI() {
        try {
            // Espera alguns segundos para garantir que o app subiu
            Thread.sleep(3000);

            String swaggerUrl = "http://localhost:3535/swagger-ui/index.html";
            String os = System.getProperty("os.name").toLowerCase();

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                // Abre no navegador padrão
                Desktop.getDesktop().browse(new URI(swaggerUrl));
                System.out.println("Swagger aberto no navegador padrão: " + swaggerUrl);
            } else {
                // Caso não suporte o Desktop, tenta abrir de acordo com o sistema operacional
                if (os.contains("win")) {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + swaggerUrl);
                } else if (os.contains("mac")) {
                    Runtime.getRuntime().exec("open " + swaggerUrl);
                } else if (os.contains("nix") || os.contains("nux")) {
                    Runtime.getRuntime().exec("xdg-open " + swaggerUrl);
                } else {
                    System.out.println("Sistema operacional não reconhecido. Abra manualmente: " + swaggerUrl);
                }
            }

            System.out.println("Tentativa de abrir Swagger em: " + swaggerUrl);
        } catch (Exception e) {
            System.err.println("Erro ao tentar abrir o navegador: " + e.getMessage());
        }
    }
}
