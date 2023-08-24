package com.dailycodework.sbemailverificationdemo.implementations;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Tramite;
import com.dailycodework.sbemailverificationdemo.repositories.ITramiteRepository;
import com.dailycodework.sbemailverificationdemo.services.ITramiteService;


@Service
public class TramiteServiceImpl implements ITramiteService {
	
	@Autowired
	private ITramiteRepository tramiteRepository;
	
	@Override
	public java.util.List<Tramite> listTramite() {
		// TODO Auto-generated method stub
		return tramiteRepository.findAll();
	}

	@Override
	public Tramite registerTramite(Tramite tramite) {
		// TODO Auto-generated method stub
		return tramiteRepository.save(tramite);
	}

	@Override
	public Tramite updateTramite(Long id, Tramite tramite) {
		Tramite tramiteExistente = tramiteRepository.findById(id).orElse(null);
        if (tramiteExistente != null) {
        	tramiteExistente.setNombre(tramite.getNombre());
        	tramiteExistente.setRequisitos(tramite.getRequisitos());
            return tramiteRepository.save(tramiteExistente);
        }
        return null;
	}

	@Override
	public boolean deleteTramite(Long id) {
		Tramite tramiteExistente = tramiteRepository.findById(id).orElse(null);
        if (tramiteExistente != null) {
        	tramiteRepository.delete(tramiteExistente);
            return true;
        }
        return false;
	}

	@Override
	public Tramite tramiteById(Long id) {
		// TODO Auto-generated method stub
		 return tramiteRepository.findById(id).orElse(null);
	}
	
}
