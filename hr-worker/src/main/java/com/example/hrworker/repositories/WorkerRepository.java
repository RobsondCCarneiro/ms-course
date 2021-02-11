package com.example.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrworker.entities.Worker;

/*
 * JpaRepository contem metodos para gerar comandos para o banco de dados automaticamente.
 */
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
