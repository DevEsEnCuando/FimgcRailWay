package com.dailycodework.sbemailverificationdemo.implementations;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dailycodework.sbemailverificationdemo.entities.Documento;
import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.entities.Expediente;
import com.dailycodework.sbemailverificationdemo.entities.ModalidadIngreso;
import com.dailycodework.sbemailverificationdemo.entities.Tramite;
import com.dailycodework.sbemailverificationdemo.repositories.IDocumentoRepository;
import com.dailycodework.sbemailverificationdemo.repositories.IEscuelaRepository;
import com.dailycodework.sbemailverificationdemo.repositories.IExpedienteRepository;
import com.dailycodework.sbemailverificationdemo.repositories.IModalidadIngresoRepository;
import com.dailycodework.sbemailverificationdemo.repositories.ITipoDocumentoRepository;
import com.dailycodework.sbemailverificationdemo.services.IExpedienteService;
import com.dailycodework.sbemailverificationdemo.user.IUserRepository;
import com.dailycodework.sbemailverificationdemo.user.User;

@Service
public class ExpedienteServiceImpl implements IExpedienteService {

	@Autowired
	private IExpedienteRepository expedienteRepository;
	
	@Autowired
    private IDocumentoRepository documentoRepository;
	
	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
    private IUserRepository userRepository;
	
	@Autowired
    private IEscuelaRepository escuelaRepository;
	
	@Autowired
    private IModalidadIngresoRepository modalidadIngresoRepository;
	

	@Override
	public List<Expediente> list() {
		return expedienteRepository.findAll();
	}
			@Override
		    public Expediente verificarExpediente(String nroExpediente) {
		        return expedienteRepository.findByNroExpediente(nroExpediente);
		    }
	
	   @Override
	    public Expediente crearExpedienteOnly( Expediente expediente) {
			Expediente oexpediente= new Expediente();
			oexpediente.setTituloTesis(expediente.getTituloTesis());
			//oexpediente.setNombreAsesor(expediente.getNombreAsesor());
			oexpediente.setNroExpediente(expediente.getNroExpediente());
			oexpediente.setFechaPresentacion(expediente.getFechaPresentacion());
	    	
			
	        return expedienteRepository.save(oexpediente);
	    }
	   
	   @Override
	    public Expediente crearExpedienteUser(Long interesadoId, Long asesorId, Expediente expediente) {
			
		   User interesado = userRepository.findById(interesadoId).orElse(null);
		   User asesor = userRepository.findById(asesorId).orElse(null);

	        if (interesado != null && asesor != null) {
	            expediente.setInteresado(interesado);
	            expediente.setAsesor(asesor);
	            
	            expediente.setEstado("En Proceso");
	            expediente.setInstancia("Secretaría de Decanatura");

	            Tramite otramite = new Tramite();
	            otramite.setId(2L);
	            expediente.setTramite(otramite);

	            Expediente expedienteGuardado = expedienteRepository.save(expediente);

	            int ultimoNumeroDocumento = 250;
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);

	            Documento documento1 = new Documento();
	            documento1.setNumeroDocumento(nuevoNumeroDocumento);
	            documento1.setExpediente(expedienteGuardado);

	            Documento nuevoDocumento = documentoRepository.save(documento1);
	            expedienteGuardado.getDocumentos().add(nuevoDocumento);

	            return expedienteGuardado;
	        }

	        return null;
		   
		   
		   
			/* Cuando nombreAsesor era atributo de Expediente :,(.
			 * Expediente oexpediente= new Expediente();
			 * oexpediente.setTituloTesis(expediente.getTituloTesis());
			 * oexpediente.setNombreAsesor(expediente.getNombreAsesor());
			 * oexpediente.setNroExpediente(expediente.getNroExpediente());
			 * oexpediente.setFechaPresentacion(expediente.getFechaPresentacion());
			 * oexpediente.setEstado("En Proceso");
			 * oexpediente.setDependencia("Secretaría de Decanatura");
			 * 
			 * 
			 * User ousuario = new User(); ousuario.setId(usuarioId); // Asignar solo el ID
			 * del usuario
			 * 
			 * //Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId); Tramite
			 * otramite = new Tramite(); otramite.setId(1L);
			 * 
			 * oexpediente.setUser(ousuario); oexpediente.setTramite(otramite);
			 * 
			 * Expediente expedienteGuardado = expedienteRepository.save(oexpediente);
			 * 
			 * int ultimoNumeroDocumento = 250; ultimoNumeroDocumento++; String
			 * nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
			 * 
			 * Documento documento1 = new Documento();
			 * documento1.setNumeroDocumento(nuevoNumeroDocumento);
			 * documento1.setExpediente(expedienteGuardado);
			 * 
			 * Documento nuevoDocumento = documentoRepository.save(documento1);
			 * expediente.getDocumentos().add(nuevoDocumento);
			 * 
			 * return expedienteGuardado;
			 */
			 
	    }
	   
	   
	   @Override
	   public Expediente crearExpedienteUserEscuela(Long interesadoId, Long asesorId, Long escuelaId, String telefono, Expediente expediente) {
			
		   User interesado = userRepository.findById(interesadoId).orElse(null);
		   User asesor = userRepository.findById(asesorId).orElse(null);
		   Escuela escuela = escuelaRepository.findById(escuelaId).orElse(null);

	        if (interesado != null && asesor != null) {
	        	interesado.setEscuela(escuela);
	        	interesado.setTelefono(telefono);
				userRepository.save(interesado);
				
	            expediente.setInteresado(interesado);
	            expediente.setAsesor(asesor);
	            
	            expediente.setEstado("En Proceso");
	            expediente.setInstancia("Secretaría de Decanatura(Proveniente de Mesa de partes)");

	            Tramite otramite = new Tramite();
	            otramite.setId(2L);
	            expediente.setTramite(otramite);

	            Expediente expedienteGuardado = expedienteRepository.save(expediente);

	         // Obtener el último número de documento para el tipo de documento específico.
	            int ultimoNumeroDocumento = documentoRepository.findMaxNumeroDocumentoByTipoDocumento(1L);
	            
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
	            
	            
	            
	            Documento documento1 = new Documento();
	            documento1.setNumeroDocumento(nuevoNumeroDocumento);
	            documento1.setExpediente(expedienteGuardado);
	            documento1.setTipoDocumento(tipoDocumentoRepository.findById(1L).orElse(null));
	            


	            Documento nuevoDocumento = documentoRepository.save(documento1);
	            expedienteGuardado.getDocumentos().add(nuevoDocumento);
	            
	            return expedienteGuardado;
	        }

	        return null;	       
		   
	
	   }
	   @Override
	   public Expediente crearExpedienteUserEscuelaBorrador(Long interesadoId, Long asesorId, Long miembroId, Long presidenteId, Long escuelaId, String telefono, Expediente expediente) {
			
		   User interesado = userRepository.findById(interesadoId).orElse(null);
		   User asesor = userRepository.findById(asesorId).orElse(null);
		   User miembro = userRepository.findById(miembroId).orElse(null);
		   User presidente = userRepository.findById(presidenteId).orElse(null);
		   Escuela escuela = escuelaRepository.findById(escuelaId).orElse(null);

	        if (interesado != null && asesor != null) {
	        	interesado.setEscuela(escuela);
	        	interesado.setTelefono(telefono);
				userRepository.save(interesado);
				
	            expediente.setInteresado(interesado);
	            expediente.setAsesor(asesor);
	            expediente.setMiembro(miembro);
	            expediente.setPresidente(presidente);
	            
	            expediente.setEstado("En Proceso");
	            expediente.setInstancia("Secretaría de Decanatura(Proveniente de Mesa de partes)");
	            
	            Tramite otramite = new Tramite();
	            otramite.setId(3L);
	            expediente.setTramite(otramite);

	            Expediente expedienteGuardado = expedienteRepository.save(expediente);

	         // Obtener el último número de documento para el tipo de documento específico.
	            int ultimoNumeroDocumento = documentoRepository.findMaxNumeroDocumentoByTipoDocumento(1L);
	            
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
	            
	            Documento documento1 = new Documento();
	            documento1.setNumeroDocumento(nuevoNumeroDocumento);
	            documento1.setExpediente(expedienteGuardado);
	            documento1.setTipoDocumento(tipoDocumentoRepository.findById(1L).orElse(null));
	            Documento nuevoDocumento = documentoRepository.save(documento1);
     
	            expedienteGuardado.getDocumentos().add(nuevoDocumento);
	            
	            return expedienteGuardado;
	        }

	        return null;
	   }
	   	
	   @Override
	   public Expediente crearExpedienteUserEscuelaBachiller(Long interesadoId, Long escuelaId, Long modalidadIngresoId, String telefono, Expediente expediente){
			
		   User interesado = userRepository.findById(interesadoId).orElse(null);
		   Escuela escuela = escuelaRepository.findById(escuelaId).orElse(null);
		   ModalidadIngreso modalidadIngreso = modalidadIngresoRepository.findById(modalidadIngresoId).orElse(null);

	        if (interesado != null && escuela != null) {
	        	interesado.setEscuela(escuela);
	        	interesado.setTelefono(telefono);
				userRepository.save(interesado);
				
	            expediente.setInteresado(interesado);
	            expediente.setModalidadIngreso(modalidadIngreso);
	            expediente.setEstado("En Proceso");
	            expediente.setInstancia("Secretaría de Decanatura(Proveniente de Mesa de partes)");
	                        
	            Tramite otramite = new Tramite();
	            otramite.setId(1L);
	            expediente.setTramite(otramite);

	            Expediente expedienteGuardado = expedienteRepository.save(expediente);

	         // Obtener el último número de documento para el tipo de documento específico.
	            int ultimoNumeroDocumento = documentoRepository.findMaxNumeroDocumentoByTipoDocumento(1L);
	            
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
	            
	            Documento documento1 = new Documento();
	            documento1.setNumeroDocumento(nuevoNumeroDocumento);
	            documento1.setExpediente(expedienteGuardado);
	            documento1.setTipoDocumento(tipoDocumentoRepository.findById(1L).orElse(null));
	            Documento nuevoDocumento = documentoRepository.save(documento1);
     
	            expedienteGuardado.getDocumentos().add(nuevoDocumento);
	            
	            return expedienteGuardado;
	        }

	        return null;
	   }
	   
	   @Override
	   public Expediente crearExpedienteUserEscuelaTitulo(Long interesadoId, Long escuelaId, String telefono, Expediente expediente){
			
		   User interesado = userRepository.findById(interesadoId).orElse(null);
		   Escuela escuela = escuelaRepository.findById(escuelaId).orElse(null);
		 
	        if (interesado != null && escuela != null) {
	        	interesado.setEscuela(escuela);
	        	interesado.setTelefono(telefono);
				userRepository.save(interesado);
				
	            expediente.setInteresado(interesado);
	            expediente.setEstado("En Proceso");
	            expediente.setInstancia("Secretaría de Decanatura(Proveniente de MP)");
	                        
	            Tramite otramite = new Tramite();
	            otramite.setId(4L);
	            expediente.setTramite(otramite);

	            Expediente expedienteGuardado = expedienteRepository.save(expediente);

	         // Obtener el último número de documento para el tipo de documento específico.
	            int ultimoNumeroDocumento = documentoRepository.findMaxNumeroDocumentoByTipoDocumento(1L);
	            
	            ultimoNumeroDocumento++;
	            String nuevoNumeroDocumento = String.valueOf(ultimoNumeroDocumento);
	            
	            Documento documento1 = new Documento();
	            documento1.setNumeroDocumento(nuevoNumeroDocumento);
	            documento1.setExpediente(expedienteGuardado);
	            documento1.setTipoDocumento(tipoDocumentoRepository.findById(1L).orElse(null));
	            Documento nuevoDocumento = documentoRepository.save(documento1);
     
	            expedienteGuardado.getDocumentos().add(nuevoDocumento);
	            
	            return expedienteGuardado;
	        }

	        return null;
	   }
	   
	   @Override
	   public void actualizarMiembros(String nroExpediente, Long miembroId, Long presidenteId) {
		   Expediente expedienteExistente = expedienteRepository.findByNroExpediente(nroExpediente);

		    if (expedienteExistente != null) {
		        // Buscar los objetos User correspondientes a los IDs de los miembros del jurado
		        User miembro = userRepository.findById(miembroId).orElse(null);
		        User presidente = userRepository.findById(presidenteId).orElse(null);

		        // Actualizar las relaciones @ManyToOne con los miembros del jurado si los datos no son nulos
		        if (miembro != null) {
		            expedienteExistente.setMiembro(miembro);
		        }

		        if (presidente != null) {
		            expedienteExistente.setPresidente(presidente);
		        }

		        expedienteRepository.save(expedienteExistente); // ¡Asegúrate de guardar los cambios en la base de datos!
		    } else {
		        // El expediente con el número de expediente proporcionado no se encontró en la base de datos.
		        // Puedes manejar este escenario de acuerdo con tus necesidades, como devolver un mensaje de error o una respuesta HTTP 404.
		    }
	   }
	   
	   
	   
	   @Override
	   public void actualizarExpedienteEscuela(String nroExpediente, Long miembroId, Long presidenteId, Expediente expediente) {
		   Expediente expedienteExistente = expedienteRepository.findByNroExpediente(nroExpediente);

		    if (expedienteExistente != null) {
		        // Buscar los objetos User correspondientes a los IDs de los miembros del jurado
		        User miembro = userRepository.findById(miembroId).orElse(null);
		        User presidente = userRepository.findById(presidenteId).orElse(null);

		        // Actualizar las relaciones @ManyToOne con los miembros del jurado si los datos no son nulos
		        if (miembro != null) {
		            expedienteExistente.setMiembroescuela(miembro);
		        }

		        if (presidente != null) {
		            expedienteExistente.setPresidenteescuela(presidente);
		        }
		        
		        expedienteExistente.setNroMemoEscuela(expediente.getNroMemoEscuela());
		        expedienteExistente.setFechaMemoEscuela(expediente.getFechaMemoEscuela());
		        expedienteExistente.setNroDictEscuela(expediente.getNroDictEscuela());
		        expedienteExistente.setFechaDictEscuela(expediente.getFechaDictEscuela());

		        expedienteRepository.save(expedienteExistente); // ¡Asegúrate de guardar los cambios en la base de datos!
		    } else {
		        // El expediente con el número de expediente proporcionado no se encontró en la base de datos.
		        // Puedes manejar este escenario de acuerdo con tus necesidades, como devolver un mensaje de error o una respuesta HTTP 404.
		    }
	   }
	   
	   
	   
	   
	   
	   
	   
	   @Value("${documentos.expedientes.dir}")
	    private String expedientesDir; // Esta propiedad debe estar configurada en tu aplicación

	    
	 
	   @Override
	   public void uploadPDFAndSetVersion1(String nroExpediente, MultipartFile file) {
		// Obtener el expediente por el número de expediente
	        Expediente expediente = expedienteRepository.findByNroExpediente(nroExpediente);
	        if (expediente == null) {
	            throw new RuntimeException("Expediente no encontrado.");
	        }
	       // Verificar si el archivo no es nulo y no está vacío
	       if (file != null && !file.isEmpty()) {
	           try {
	               // Construir la ruta del directorio "documentos/Expedientes" utilizando java.nio.file.Paths
	               String expedientesDir = System.getProperty("user.dir") + "/documentos/Expedientes/";
	               Path directoryPath = Paths.get(expedientesDir);

	               // Crear el directorio si no existe
	               if (!Files.exists(directoryPath)) {
	                   Files.createDirectories(directoryPath);
	               }

	               // Obtener el nombre original del archivo
	               String originalFilename = file.getOriginalFilename();

	               // Construir la ruta completa del archivo
	               String filePath = expedientesDir + originalFilename;
	               Path path = Paths.get(filePath);

	               // Guardar el archivo en la ruta especificada
	               Files.write(path, file.getBytes());

	               // Actualizar la columna "version1" del expediente con la ruta del archivo
	               expediente.setRutaDocumento(filePath);
	               
	               if (expediente.getVersion() == null) {
	                   expediente.setVersion("MM_Expediente");
	                   expediente.setInstancia("Jurado Revisor");
	               }else if (expediente.getVersion().equals("MM_Expediente")) {
		               expediente.setVersion("Dict_MM_Expediente");
		               expediente.setInstancia("Secretaría de Decanatura(Proveniente del Jurado Revisor)");
	               }else if (expediente.getVersion().equals("Dict_MM_Expediente")) {
		               expediente.setVersion("RD_Dict_MM_Expediente");
		               expediente.setInstancia("Entregado a los interesados");
		               expediente.setEstado("Finalizado");
	               }

	               // Guardar el expediente actualizado en la base de datos
	               expedienteRepository.save(expediente);

	           } catch (IOException e) {
	               throw new RuntimeException("Error al subir el archivo PDF.", e);
	           }
	       } else {
	           throw new RuntimeException("El archivo PDF está vacío o nulo.");
	       }
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	@Override
	public Expediente registerExpediente(Expediente expediente) {
		return expedienteRepository.save(expediente);
	}

	
	  @Override public byte[] findVersionByIdAndNumber(Long id, int versionNumber)
	  { 
			/*
			 * Expediente expediente = expedienteRepository.findById(id) .orElseThrow(() ->
			 * new RuntimeException("No se encontró el expediente con ID " + id));
			 * 
			 * switch (versionNumber) { case 1: return expediente.getVersion1(); case 2:
			 * return expediente.getVersion2(); case 3: return expediente.getVersion3();
			 * case 4: return expediente.getVersion4(); default: throw new
			 * IllegalArgumentException("Número de versión inválido: " + versionNumber); }
			 */
		  return null;
	  }
	 

	@Override
	public Expediente findExpedienteByNroExpediente(Long nroExpediente) {
		return expedienteRepository.findExpedienteByNroExpediente(nroExpediente);
	}
	@Override
	public Expediente findExpedienteByEstado(Long estado) {
		return expedienteRepository.findExpedienteByEstado(estado);
	}
	

}
