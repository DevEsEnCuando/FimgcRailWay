package com.dailycodework.sbemailverificationdemo.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.PlanEstudios;



@Repository
public interface IPlanEstudiosRepository extends JpaRepository<PlanEstudios,Long> {

	public PlanEstudios findPlanEstudiosById(Long id);
	List<PlanEstudios> findByEscuelaId(Long escuelaId);
	@Query("SELECT p FROM PlanEstudios p WHERE p.escuela.id = :escuelaId")
    List<PlanEstudios> findByEscuela_Id(Long escuelaId);
	
	
}
