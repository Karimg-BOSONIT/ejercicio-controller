package org.example.ejerciciocontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class EjercicioControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioControllerApplication.class, args);
	}

	@Bean
	public MyFilter myFilter() {
		return new MyFilter();
	}
}
