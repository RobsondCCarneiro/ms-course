package com.example.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
 * Agora utilizando o ribbon client, vamos ter que colocar
 * essa anotation
 */
@RibbonClient(name = "hr-worker")
@EnableFeignClients
@SpringBootApplication
public class HrPayroolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayroolApplication.class, args);
	}

}
