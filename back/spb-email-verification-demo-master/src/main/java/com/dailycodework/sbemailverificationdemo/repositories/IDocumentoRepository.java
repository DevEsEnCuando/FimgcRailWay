package com.dailycodework.sbemailverificationdemo.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailycodework.sbemailverificationdemo.entities.Documento;
import com.dailycodework.sbemailverificationdemo.entities.Expediente;


@Repository
public interface IDocumentoRepository extends JpaRepository<Documento,Long>{
	public Documento findDocumentoById(Long id); 
	public List<Documento> findDocumentoByExpediente(Expediente expediente);
	
	// Consulta para obtener el último número de documento para un tipo de documento específico.
    @Query("SELECT MAX(d.numeroDocumento) FROM Documento d WHERE d.tipoDocumento.id = :tipoDocId")
    public int findMaxNumeroDocumentoByTipoDocumento(Long tipoDocId);
    
    // Consulta para traer un documento de acuerdo al nro_expediente
    @Query("SELECT d FROM Documento d JOIN d.expediente e WHERE e.nroExpediente = :nroExpediente AND d.tipoDocumento.id= :tipoDocId")
    Documento findByNroExpediente(String nroExpediente,Long tipoDocId );
}
