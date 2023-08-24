package com.dailycodework.sbemailverificationdemo.services;



import java.util.List;

import com.dailycodework.sbemailverificationdemo.entities.PlanEstudios;



public interface IPlanEstudiosService {

	public abstract List<PlanEstudios> list();
	PlanEstudios register(PlanEstudios entity);
	PlanEstudios update(Long id, PlanEstudios planEstudios);
	List<PlanEstudios> obtenerPlanEstudiosPorEscuela(Long escuelaId);
	boolean delete(Long id);
	PlanEstudios findPlanById(Long id);
	List<PlanEstudios> listByEscuela(Long escuela);
	
	
}
