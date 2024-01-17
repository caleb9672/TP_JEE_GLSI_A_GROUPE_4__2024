package iai.glsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "iai.glsi")
public class ActiviteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiviteApplication.class, args);
	}

}
