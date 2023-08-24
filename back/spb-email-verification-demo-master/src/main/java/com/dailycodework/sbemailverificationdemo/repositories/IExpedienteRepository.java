package com.dailycodework.sbemailverificationdemo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.Expediente;



@Repository
public interface IExpedienteRepository extends JpaRepository<Expediente, Long>{
	 	public Expediente findByNroExpediente(String nroExpediente);
	 public Expediente findExpedienteByNroExpediente(Long id);
	 public Expediente findExpedienteByEstado(Long id);
}