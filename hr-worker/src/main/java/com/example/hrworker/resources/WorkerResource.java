package com.example.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		Worker obj = repository.findById(id).get();
		
		return ResponseEntity.ok(obj);
	}
}
