package com.dailycodework.sbemailverificationdemo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.Tramite;



@Repository
public interface ITramiteRepository extends JpaRepository<Tramite, Long> {
	public Tramite findTramiteById(Long id);
}
