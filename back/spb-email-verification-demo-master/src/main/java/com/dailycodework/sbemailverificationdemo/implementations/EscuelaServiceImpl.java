package com.dailycodework.sbemailverificationdemo.implementations;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.repositories.IEscuelaRepository;
import com.dailycodework.sbemailverificationdemo.services.IEscuelaService;



@Service
public class EscuelaServiceImpl implements IEscuelaService{
	
	@Autowired
	private IEscuelaRepository escuelaRepository;
	

	
	@Override
	public List<Escuela> list() {
		
		return escuelaRepository.findAll();
	}
	

	@Override
	public Escuela register(Escuela escuela) {
		// TODO Auto-generated method stub
		return escuelaRepository.save(escuela);
	}

	@Override
	public Escuela update(Long id, Escuela escuela) {
		Escuela escuelaExistente = escuelaRepository.findById(id).orElse(null);
        if (escuelaExistente != null) {
        	escuelaExistente.setNombre(escuela.getNombre());
        	escuelaExistente.setNombreGradoBachiller(escuela.getNombreGradoBachiller());
        	escuelaExistente.setDirector(escuela.getDirector());
            return escuelaRepository.save(escuelaExistente);
        }
        return null;
	}
	
	@Override
	public boolean delete(Long id) {
		Escuela escuelaExistente = escuelaRepository.findById(id).orElse(null);
        if (escuelaExistente != null) {
        	escuelaRepository.delete(escuelaExistente);
            return true;
        }
        return false;
    }
	
	@Override
	public Escuela escuelaById(Long id) {
		// TODO Auto-generated method stub
		 return escuelaRepository.findById(id).orElse(null);
	}

	

}
