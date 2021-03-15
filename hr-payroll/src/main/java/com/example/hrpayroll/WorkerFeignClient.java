package com.example.hrpayroll;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hrpayroll.entities.Worker;

/*
 * O FeignClient serve para conectar os microsservicos de hrpayroll com o hrworker.
 * A partir daqui a conexão entre os serviços serão automáticas, por enquanto
 * é necessário que colocar todos os parametros que estao no resouces->application.proprieties
 */
@Component
//@FeignClient(name = "hr-worker", url = "localhost:8001", path="/workers")
@FeignClient(name = "hr-worker", path="/workers")
public interface WorkerFeignClient {

	@GetMapping(value= "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
