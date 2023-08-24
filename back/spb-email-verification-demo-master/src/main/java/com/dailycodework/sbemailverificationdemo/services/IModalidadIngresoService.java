package com.dailycodework.sbemailverificationdemo.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.ModalidadIngreso;



@Service
public interface IModalidadIngresoService {
	List<ModalidadIngreso> list();

	ModalidadIngreso register(ModalidadIngreso entity);
	ModalidadIngreso update(Long id, ModalidadIngreso escuela);
	boolean delete(Long id);
	ModalidadIngreso modalidadById(Long id);

}
