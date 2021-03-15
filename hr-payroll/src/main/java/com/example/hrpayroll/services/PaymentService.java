package com.example.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrpayroll.WorkerFeignClient;
import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	/*
	 * Utilizando a anotação value para não precisar ficar colocando o
	 * endereço do host em cada metodo, desta forma, coloquei o valor
	 * dentro de application.properties pegando a porta do outro programa
	 * para linkar com este.
	 */
	
	//Como foi criado a variável workerFeignClient, este trecho ficou inutil
	/*@Value("${hr-worker.host}")
	private String workerHost;*/
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	/*@Autowired
	private RestTemplate restTemplate;*/

	public Payment getPayment(long workerId, int days) {
		
		//Como nao eh mais uma requisicao com o RestTemplate, este trecho eh desnecessario.
		/*Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);*/
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
