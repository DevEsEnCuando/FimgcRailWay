package com.dailycodework.sbemailverificationdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;

@Service
public interface IEscuelaService {
	List<Escuela> list();

	Escuela register(Escuela entity);
	Escuela update(Long id, Escuela escuela);
	boolean delete(Long id);
	Escuela escuelaById(Long id);
}
