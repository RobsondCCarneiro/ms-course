package com.example.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/*
	 * Metodo que serve para registrar uma instancia unica do objeto
	 * do tipo RestTemplate. Fica disponivel para injetar os componentes.
	 * Basicamente criar os componentes a partir de uma chamada de metodo,
	 * ao invés de ser na classe. 
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
