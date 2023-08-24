package com.dailycodework.sbemailverificationdemo.services;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Documento;


@Service
public interface IDocumentoService {
	List<Documento> list();
	Documento update(Documento entity);
	Documento findDocumentoById(Long id);
	List<Documento> findDocumentoByExpediente(Long id);
		void actualizarDatosDictamen(String nroExpediente, Documento documento);
		void actualizarDatosConstancia(String nroExpediente, Documento documento);
		void actualizarSustentacion(String nroExpediente, Documento documento, Long secredocenteId);
		void actualizarSesionCF(String nroExpediente, Date fechaSesionCF);
}
