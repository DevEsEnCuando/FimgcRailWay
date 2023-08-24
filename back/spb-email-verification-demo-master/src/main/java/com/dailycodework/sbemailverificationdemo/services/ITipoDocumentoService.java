package com.dailycodework.sbemailverificationdemo.services;



import java.util.List;

import com.dailycodework.sbemailverificationdemo.entities.TipoDocumento;



public interface ITipoDocumentoService {
	List<TipoDocumento> list();
	TipoDocumento register(TipoDocumento entity);
	TipoDocumento update(Long id, TipoDocumento tipoDocumento);
	void deleteTipoDocumento(Long id);
	/*TipoDocumento findTipoDocumentoById(Long id);
	TipoDocumento findTipoDocumentoByNombre(String nombre);*/
}
