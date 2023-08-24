package com.dailycodework.sbemailverificationdemo.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.ModalidadIngreso;
import com.dailycodework.sbemailverificationdemo.repositories.IModalidadIngresoRepository;
import com.dailycodework.sbemailverificationdemo.services.IModalidadIngresoService;

@Service
public class ModalidadIngresoServiceImpl implements IModalidadIngresoService{

	@Autowired
	private IModalidadIngresoRepository modalidadIngresoRepository;
	@Override
	public List<ModalidadIngreso> list() {
		return modalidadIngresoRepository.findAll();
	}

	@Override
	public ModalidadIngreso register(ModalidadIngreso modalidadIngreso) {
		return modalidadIngresoRepository.save(modalidadIngreso);
	}

	@Override
	public ModalidadIngreso update(Long id, ModalidadIngreso modalidadIngreso) {
		ModalidadIngreso modalidadIngresoExistente = modalidadIngresoRepository.findById(id).orElse(null);
        if (modalidadIngresoExistente != null) {
        	modalidadIngresoExistente.setNombre(modalidadIngreso.getNombre());
        	modalidadIngresoExistente.setDescripcion(modalidadIngreso.getDescripcion());
            return modalidadIngresoRepository.save(modalidadIngresoExistente);
        }
        return null;
	}

	@Override
	public boolean delete(Long id) {
		ModalidadIngreso modalidadIngresoExistente = modalidadIngresoRepository.findById(id).orElse(null);
        if (modalidadIngresoExistente != null) {
        	modalidadIngresoRepository.delete(modalidadIngresoExistente);
            return true;
        }
        return false;
    }

	@Override
	public ModalidadIngreso modalidadById(Long id) {
		return modalidadIngresoRepository.findById(id).orElse(null);
	}
	

}
