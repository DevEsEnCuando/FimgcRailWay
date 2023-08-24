package com.dailycodework.sbemailverificationdemo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.Rol;



@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
	Rol findByNombre(String nombre);

}
