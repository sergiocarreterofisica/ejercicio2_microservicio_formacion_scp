package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication(scanBasePackages = {"com.curso.service.*", "com.curso.controller"})
public class MicroservicioFormacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioFormacionApplication.class, args);
	}

	@Bean
	RestClient client() {
		return RestClient.create();
	}
	
}
