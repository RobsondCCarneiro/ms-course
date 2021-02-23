package com.example.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
