package dev.fastcleanapi.fastcleanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dev.fastcleanapi.fastcleanapi")
public class FastcleanapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastcleanapiApplication.class, args);
	}

}
