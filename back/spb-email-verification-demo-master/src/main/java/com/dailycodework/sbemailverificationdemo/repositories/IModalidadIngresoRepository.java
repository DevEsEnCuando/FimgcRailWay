package com.dailycodework.sbemailverificationdemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.ModalidadIngreso;


@Repository
public interface IModalidadIngresoRepository extends JpaRepository<ModalidadIngreso,Long>{
	public Optional<ModalidadIngreso> findById(Long id);
	public ModalidadIngreso findModalidadById(Long id);

}
