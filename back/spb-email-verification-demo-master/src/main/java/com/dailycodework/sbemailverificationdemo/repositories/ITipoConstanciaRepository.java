package com.dailycodework.sbemailverificationdemo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.TipoConstancia;



@Repository
public interface ITipoConstanciaRepository extends JpaRepository<TipoConstancia,Long> {

}
