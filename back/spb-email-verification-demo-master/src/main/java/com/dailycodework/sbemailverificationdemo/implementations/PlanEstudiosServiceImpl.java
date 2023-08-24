package com.dailycodework.sbemailverificationdemo.implementations;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.entities.PlanEstudios;
import com.dailycodework.sbemailverificationdemo.repositories.IEscuelaRepository;
import com.dailycodework.sbemailverificationdemo.repositories.IPlanEstudiosRepository;
import com.dailycodework.sbemailverificationdemo.services.IPlanEstudiosService;


@Service
public class PlanEstudiosServiceImpl implements IPlanEstudiosService{
	@Autowired
	private IPlanEstudiosRepository planEstudiosRepository;
	
	@Autowired
    private IEscuelaRepository escuelaRepository;

	@Override
	public List<PlanEstudios> list() {
		
		return planEstudiosRepository.findAll();	
	}
	@Override
    public List<PlanEstudios> listByEscuela(Long escuelaId) {
        return planEstudiosRepository.findByEscuelaId(escuelaId);
    }

	@Override
	public PlanEstudios register(PlanEstudios planEstudios) {
		Long escuelaId = planEstudios.getEscuela().getId();// Acceder al atributo escuelaId directamente
	    Optional<Escuela> escuelaOptional = escuelaRepository.findById(escuelaId);
	    if (escuelaOptional.isEmpty()) {
	    	System.out.println("La escuela no existe");
	        return new PlanEstudios();
	    } else {
	        return planEstudiosRepository.save(planEstudios);
	    }
		
	}

	@Override
	public PlanEstudios update(Long id, PlanEstudios planEstudios) {
		// TODO Auto-generated method stub
		PlanEstudios planEstudiosExistente = planEstudiosRepository.findById(id).orElse(null);
        if (planEstudiosExistente != null) {
        	planEstudiosExistente.setAnioPlan(planEstudios.getAnioPlan());
        	planEstudiosExistente.setNombrePlan(planEstudios.getNombrePlan());
        	planEstudiosExistente.setEscuela(planEstudios.getEscuela());
        	planEstudiosExistente.setTipoC1(planEstudios.getTipoC1());
        	planEstudiosExistente.setTipoC2(planEstudios.getTipoC2());
        	planEstudiosExistente.setTipoC3(planEstudios.getTipoC3());
        	planEstudiosExistente.setTipoC4(planEstudios.getTipoC4());
        	planEstudiosExistente.setTipoC5(planEstudios.getTipoC5());
        	planEstudiosExistente.setTipoC6(planEstudios.getTipoC6());
        	planEstudiosExistente.setTipoC7(planEstudios.getTipoC7());
        	planEstudiosExistente.setTipoC8(planEstudios.getTipoC8());
        	
        	planEstudiosExistente.setValorC1(planEstudios.getValorC1());
        	planEstudiosExistente.setValorC2(planEstudios.getValorC2());
        	planEstudiosExistente.setValorC3(planEstudios.getValorC3());
        	planEstudiosExistente.setValorC4(planEstudios.getValorC4());
        	planEstudiosExistente.setValorC5(planEstudios.getValorC5());
        	planEstudiosExistente.setValorC6(planEstudios.getValorC6());
        	planEstudiosExistente.setValorC7(planEstudios.getValorC7());
        	planEstudiosExistente.setValorC8(planEstudios.getValorC8());
            return planEstudiosRepository.save(planEstudiosExistente);
        }
        return null;
	}
	
	@Override
	public boolean delete(Long id) {
		PlanEstudios planExistente = planEstudiosRepository.findById(id).orElse(null);
        if (planExistente != null) {
        	planEstudiosRepository.delete(planExistente);
            return true;
        }
        return false;
    }
	
	@Override
	public PlanEstudios findPlanById(Long id) {
	    return planEstudiosRepository.findById(id).orElse(null);
	}
	@Override
	public List<PlanEstudios> obtenerPlanEstudiosPorEscuela(Long escuelaId) {
		// TODO Auto-generated method stub
		return null;
	}


}
