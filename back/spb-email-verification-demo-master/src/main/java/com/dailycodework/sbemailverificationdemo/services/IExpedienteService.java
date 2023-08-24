package com.dailycodework.sbemailverificationdemo.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dailycodework.sbemailverificationdemo.entities.Expediente;
@Service
public interface IExpedienteService {
    List<Expediente> list();
    	Expediente verificarExpediente(String nroExpediente);
    Expediente registerExpediente(Expediente expediente);
    Expediente findExpedienteByNroExpediente(Long id);
    Expediente findExpedienteByEstado(Long id);
    byte[] findVersionByIdAndNumber(Long id, int versionNumber);
    	Expediente crearExpedienteOnly(Expediente expediente);
    	Expediente crearExpedienteUser(Long interesadoId, Long asesorId, Expediente expediente);
    	Expediente crearExpedienteUserEscuela(Long interesadoId, Long asesorId, Long escuelaId, String telefono, Expediente expediente);
    	Expediente crearExpedienteUserEscuelaBorrador(Long interesadoId, Long asesorId, Long miembroId, Long presidenteId,Long escuelaId, String telefono, Expediente expediente);
    	void actualizarMiembros(String nroExpediente, Long miembroId, Long presidenteId);
    	void actualizarExpedienteEscuela(String nroExpediente, Long miembroId, Long presidenteId, Expediente expediente);
    	Expediente crearExpedienteUserEscuelaBachiller(Long interesadoId, Long escuelaId, Long modalidadIngresoId, String telefono, Expediente expediente);
    	Expediente crearExpedienteUserEscuelaTitulo(Long interesadoId, Long escuelaId, String telefono, Expediente expediente);
    	
    	void uploadPDFAndSetVersion1(String nroExpediente, MultipartFile file);
 }
