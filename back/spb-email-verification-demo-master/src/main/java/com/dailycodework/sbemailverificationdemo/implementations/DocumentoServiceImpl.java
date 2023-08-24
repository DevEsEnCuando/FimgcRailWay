package com.dailycodework.sbemailverificationdemo.implementations;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbemailverificationdemo.entities.Documento;
import com.dailycodework.sbemailverificationdemo.entities.Expediente;
import com.dailycodework.sbemailverificationdemo.entities.TipoDocumento;
import com.dailycodework.sbemailverificationdemo.repositories.IDocumentoRepository;
import com.dailycodework.sbemailverificationdemo.repositories.IExpedienteRepository;
import com.dailycodework.sbemailverificationdemo.repositories.ITipoDocumentoRepository;
import com.dailycodework.sbemailverificationdemo.services.IDocumentoService;
import com.dailycodework.sbemailverificationdemo.user.IUserRepository;
import com.dailycodework.sbemailverificationdemo.user.User;

@Service
public class DocumentoServiceImpl implements IDocumentoService {
	
	@Autowired
	private IDocumentoRepository documentoRepository;
	//private IExpedienteRepository escuelaRepository;
	
	@Autowired
    private IUserRepository userRepository;
	
	@Autowired
	private IExpedienteRepository expedienteRepository;
	
	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	@Override
	public List<Documento> list() {
		return documentoRepository.findAll();
	}

	@Override
	public Documento update(Documento entity) {
		// TODO Auto-generated method stub
		return documentoRepository.save(entity);
	}

	@Override
	public Documento findDocumentoById(Long id) {
		// TODO Auto-generated method stub
		return documentoRepository.findDocumentoById(id);
	}

	@Override
	public List<Documento> findDocumentoByExpediente(Long id) {
		// TODO Auto-generated method stub
		//Expediente expediente=expedienteRepository.find(id);
		return null;
	}
	
	@Override
	public void actualizarDatosDictamen(String nroExpediente, Documento documento) {
	    // Verificar que los parámetros no sean nulos
	    if (nroExpediente != null && documento != null) {
	        Documento nuevoDocumento = new Documento();

	        // Establecer la fecha actual como fechaGeneracion
	        nuevoDocumento.setFechaGeneracion(documento.getFechaGeneracion());
	        // Establecer el número de documento proporcionado
	        nuevoDocumento.setNumeroDocumento(documento.getNumeroDocumento());
	        nuevoDocumento.setResultado(documento.getResultado());        

	        // Buscar el expediente existente por nroExpediente proporcionado
	        Expediente expedienteExistente = expedienteRepository.findByNroExpediente(nroExpediente);
	        if (expedienteExistente == null) {
	            throw new IllegalArgumentException("No se encontró un expediente con el nroExpediente proporcionado.");
	        }

	        // Buscar el TipoDocumento con Id=3 (Tipo dictamen) en la base de datos
	        TipoDocumento tipoDictamen = tipoDocumentoRepository.findById(2L).orElse(null);
	        if (tipoDictamen == null) {
	            throw new IllegalArgumentException("No se encontró un TipoDocumento con ID 2 (Tipo dictamen).");
	        }

	        // Asignar el expediente existente y el TipoDocumento al nuevo documento
	        nuevoDocumento.setExpediente(expedienteExistente);
	        nuevoDocumento.setTipoDocumento(tipoDictamen);

	        
	        if ("Apto".equals(documento.getResultado())) {
	        	
	        	//Para sumar un año de plazo
		        Calendar fechaGeneracion = Calendar.getInstance();
		        fechaGeneracion.setTime(documento.getFechaGeneracion());
		        // Añadimos un año a la fecha de generación
		        fechaGeneracion.add(Calendar.YEAR, 1);
		        // Ahora puedes asignar la fecha modificada a la fecha de plazo del nuevo documento
		        nuevoDocumento.setFechaPlazo(fechaGeneracion.getTime());
		        
	        	if (!"Borrador de Tesis".equals(expedienteExistente.getTramite().getNombre())) {
		        // Obtener el último número de documento para el tipo de documento específico.
	            int ultimoNumeroDocumento = documentoRepository.findMaxNumeroDocumentoByTipoDocumento(3L);
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
	            Documento resolucion = new Documento();
	            resolucion.setNumeroDocumento(nuevoNumeroDocumento);
	            resolucion.setExpediente(expedienteExistente);
	            resolucion.setTipoDocumento(tipoDocumentoRepository.findById(3L).orElse(null));
		        documentoRepository.save(resolucion);
		        }
	        }    
	        
	        // Guardar el nuevo documento en la base de datos
	        documentoRepository.save(nuevoDocumento);
            
	    } else {
	        throw new IllegalArgumentException("El número de expediente o el documento proporcionado son nulos.");
	    }
	}
	
	@Override
	public void actualizarDatosConstancia(String nroExpediente, Documento documento) {
	    // Verificar que los parámetros no sean nulos
	    if (nroExpediente != null && documento != null) {
	        Documento nuevoDocumento = new Documento();

	        // Establecer la fecha actual como fechaGeneracion
	        nuevoDocumento.setFechaGeneracion(documento.getFechaGeneracion());
	        // Establecer el número de documento proporcionado
	        nuevoDocumento.setNumeroDocumento(documento.getNumeroDocumento());
	        nuevoDocumento.setResultado(documento.getResultado());        

	        // Buscar el expediente existente por nroExpediente proporcionado
	        Expediente expedienteExistente = expedienteRepository.findByNroExpediente(nroExpediente);
	        if (expedienteExistente == null) {
	            throw new IllegalArgumentException("No se encontró un expediente con el nroExpediente proporcionado.");
	        }

	        // Buscar el TipoDocumento con Id=3 (Tipo dictamen) en la base de datos
	        TipoDocumento tipoDictamen = tipoDocumentoRepository.findById(4L).orElse(null);
	        if (tipoDictamen == null) {
	            throw new IllegalArgumentException("No se encontró un TipoDocumento con ID 4 (Tipo dictamen).");
	        }

	        // Asignar el expediente existente y el TipoDocumento al nuevo documento
	        nuevoDocumento.setExpediente(expedienteExistente);
	        nuevoDocumento.setTipoDocumento(tipoDictamen);

	        
	        if ("Apto".equals(documento.getResultado()) && "Borrador de Tesis".equals(expedienteExistente.getTramite().getNombre())) {       
	        	
		        // Obtener el último número de documento para el tipo de documento específico.
	            int ultimoNumeroDocumento = documentoRepository.findMaxNumeroDocumentoByTipoDocumento(3L);
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
	            Documento resolucion = new Documento();
	            resolucion.setNumeroDocumento(nuevoNumeroDocumento);
	            resolucion.setExpediente(expedienteExistente);
	            resolucion.setTipoDocumento(tipoDocumentoRepository.findById(3L).orElse(null));
		        documentoRepository.save(resolucion);
	        }    
	        
	        // Guardar el nuevo documento en la base de datos
	        documentoRepository.save(nuevoDocumento);
            
	    } else {
	        throw new IllegalArgumentException("El número de expediente o el documento proporcionado son nulos.");
	    }
	}
	
	@Override
	   public void actualizarSustentacion(String nroExpediente, Documento documento, Long secredocenteId) {
		   Expediente expedienteExistente = expedienteRepository.findByNroExpediente(nroExpediente);
		   Documento documentoExistente = documentoRepository.findByNroExpediente(nroExpediente,3L);
		    if (expedienteExistente != null && documentoExistente != null) {
		        // Buscar los objetos User correspondientes a los IDs de los miembros del jurado
		        User secredocente = userRepository.findById(secredocenteId).orElse(null);
		        documentoExistente.setFechaSustentacion(documento.getFechaSustentacion());
		        documentoExistente.setHoraSustentacion(documento.getHoraSustentacion());
		        documentoExistente.setLugarSustentacion(documento.getLugarSustentacion());
		        documentoRepository.save(documentoExistente);
		        // Actualizar las relaciones @ManyToOne con los miembros del jurado si los datos no son nulos
		        if (secredocente != null) {
		            expedienteExistente.setSecredocente(secredocente);
		            }
		        expedienteRepository.save(expedienteExistente); // ¡Asegúrate de guardar los cambios en la base de datos!
		    } else {
		        // El expediente con el número de expediente proporcionado no se encontró en la base de datos.
		        // Puedes manejar este escenario de acuerdo con tus necesidades, como devolver un mensaje de error o una respuesta HTTP 404.
		    }
	   }
	
	@Override
	   public void actualizarSesionCF(String nroExpediente, Date fechaSesionCF) {
		   Expediente expedienteExistente = expedienteRepository.findByNroExpediente(nroExpediente);
		   Documento documentoExistente = documentoRepository.findByNroExpediente(nroExpediente,3L);
		    if (expedienteExistente != null && documentoExistente != null) {
		        
		        documentoExistente.setFechaSesionCF(fechaSesionCF);
		        documentoRepository.save(documentoExistente);
		        expedienteRepository.save(expedienteExistente); // ¡Asegúrate de guardar los cambios en la base de datos!
		    } else {
		        // El expediente con el número de expediente proporcionado no se encontró en la base de datos.
		        // Puedes manejar este escenario de acuerdo con tus necesidades, como devolver un mensaje de error o una respuesta HTTP 404.
		    }
	   }
	
	

}
