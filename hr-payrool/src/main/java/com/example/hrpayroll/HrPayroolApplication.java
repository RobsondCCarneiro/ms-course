package com.example.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
 * Como o Eureka jah tem o balanço de carga, entao a anotacao
 * do RibbonClient nao eh mais necessaria.
 */
//@RibbonClient(name = "hr-worker")
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class HrPayroolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayroolApplication.class, args);
	}

}
