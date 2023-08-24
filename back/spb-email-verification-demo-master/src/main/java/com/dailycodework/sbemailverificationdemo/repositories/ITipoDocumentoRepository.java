package com.dailycodework.sbemailverificationdemo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.TipoDocumento;



@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento,Long> {
	public TipoDocumento findTipoDocumentoById(Long id);
	public TipoDocumento findTipoDocumentoByNombre(String nombre);
	
	
}
