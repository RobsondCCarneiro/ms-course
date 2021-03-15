	package com.example.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value="/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		/*
		 * Só esta linha, ela vai para o banco de dados, busca todos os dados,
		 * instancia a lista e devolve para ser retornado
		 */
		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		//Simulando a espera para dar timeout no servidor.
		/*try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Quando for fazer a requisicao por id, o logger.info serve para imprimir
		 * a mensagem de informacao da aplicacao 
		 */
		logger.info("PORT " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		
		return ResponseEntity.ok(obj);
	}
}
