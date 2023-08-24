package com.dailycodework.sbemailverificationdemo.implementations;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.TipoDocumento;
import com.dailycodework.sbemailverificationdemo.repositories.ITipoDocumentoRepository;
import com.dailycodework.sbemailverificationdemo.services.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService{
	
    @Autowired
    private ITipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> list() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento register(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }
    
    @Override
    public TipoDocumento update(Long id, TipoDocumento tipoDocumento) {
        TipoDocumento tipoDocumentoExistente = tipoDocumentoRepository.findById(id).orElse(null);
        if (tipoDocumentoExistente != null) {
            tipoDocumentoExistente.setNombre(tipoDocumento.getNombre());
            tipoDocumentoExistente.setDescripcion(tipoDocumento.getDescripcion());
            tipoDocumentoExistente.setSigla(tipoDocumento.getSigla());
            return tipoDocumentoRepository.save(tipoDocumentoExistente);
        }
        return null;
    }
    public void deleteTipoDocumento(Long id) {
		tipoDocumentoRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public TipoDocumento findTipoDocumentoById(Long id) { return
	 * tipoDocumentoRepository.findById(id).orElse(null); }
	 * 
	 * @Override public TipoDocumento findTipoDocumentoByNombre(String nombre) {
	 * return tipoDocumentoRepository.findTipoDocumentoByNombre(nombre); }
	 */
 

}
