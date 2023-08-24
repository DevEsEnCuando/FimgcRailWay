package com.dailycodework.sbemailverificationdemo.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.entities.Expediente;
import com.dailycodework.sbemailverificationdemo.services.IExpedienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/expediente")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpedienteController {

	@Autowired
	private IExpedienteService expedienteService;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:5173")
	public List<Expediente> listarExpediente() {
		return expedienteService.list();
	}

	
	@GetMapping("/{nroExpediente}/V")
    @CrossOrigin(origins = "http://localhost:5173")
    public Expediente verificarExpediente(@PathVariable("nroExpediente") String nroExpediente) {
        
		return expedienteService.verificarExpediente(nroExpediente);
    }
	
//	@GetMapping("/{id}")
//    @CrossOrigin(origins = "http://localhost:5173")
//    public Escuela obtenerEscuelaPorID(@PathVariable("id") Long id) {
//        return escuelaService.escuelaById(id);
//    }

	@PostMapping("/expedienteOnly")
	public Expediente crearExpedienteOnly(@RequestBody Expediente expediente) {
		return expedienteService.crearExpedienteOnly(expediente);
	}

	@PostMapping("/{interesadoId}/expedienteUser")
	public ResponseEntity<String> crearExpedienteUser(@PathVariable Long interesadoId, @RequestParam Long asesorId,
			@RequestBody Expediente expediente) {
		try {
			expedienteService.crearExpedienteUser(interesadoId, asesorId, expediente);
			return ResponseEntity.ok("Registro Exitoso");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el registro", e);
		}
	}

	@PostMapping("/{interesadoId}/expedienteUserEscuela")
	public ResponseEntity<String> crearExpedienteUserEscuela(@PathVariable Long interesadoId, @RequestParam Long asesorId,
			@RequestParam Long escuelaId, @RequestParam String telefono, @RequestBody Expediente expediente) {
		try {
			expedienteService.crearExpedienteUserEscuela(interesadoId, asesorId, escuelaId, telefono, expediente);
			return ResponseEntity.ok("Registro Exitoso");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el registro", e);
		}
	}

	@PostMapping("/{interesadoId}/expedienteUserEscuelaBorrador")
	public ResponseEntity<String> crearExpedienteUserEscuelaBorrador(@PathVariable Long interesadoId, @RequestParam Long asesorId,
			@RequestParam Long miembroId, @RequestParam Long presidenteId, @RequestParam Long escuelaId,
			@RequestParam String telefono, @RequestBody Expediente expediente) {
		try {
			expedienteService.crearExpedienteUserEscuelaBorrador(interesadoId, asesorId, miembroId, presidenteId,escuelaId, telefono, expediente);
			return ResponseEntity.ok("Registro Exitoso");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el registro", e);
		}
		
	}

	@PostMapping("/{interesadoId}/expedienteUserEscuelaBachiller")
	public ResponseEntity<String> crearExpedienteUserEscuelaBachiller(@PathVariable Long interesadoId, @RequestParam Long escuelaId,
			@RequestParam Long modalidadIngresoId, @RequestParam String telefono, @RequestBody Expediente expediente) {
		
		try {
			expedienteService.crearExpedienteUserEscuelaBachiller(interesadoId, escuelaId, modalidadIngresoId,telefono, expediente);
			return ResponseEntity.ok("Registro Exitoso");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el registro", e);
		}
	}

	@PostMapping("/{interesadoId}/expedienteUserEscuelaTitulo")
	public ResponseEntity<String> crearExpedienteUserEscuelaTitulo(@PathVariable Long interesadoId, @RequestParam Long escuelaId,
			@RequestParam String telefono, @RequestBody Expediente expediente) {
		
		try {
			expedienteService.crearExpedienteUserEscuelaTitulo(interesadoId, escuelaId, telefono, expediente);
			return ResponseEntity.ok("Registro Exitoso");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el registro", e);
		}
	}

	// Endpoint para actualizar nombreMiembro y nombrePresidente
	@PostMapping("/{nroExpediente}/actualizarMiembros")
	public ResponseEntity<String> actualizarMiembros(@PathVariable String nroExpediente, @RequestParam Long miembroId,
			@RequestParam Long presidenteId) throws NotFoundException {
		try {
			expedienteService.actualizarMiembros(nroExpediente, miembroId, presidenteId);
			return ResponseEntity.ok("Campos actualizados exitosamente.");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar los campos", e);
		}
	}

	// Endpoint para actualizar los datos provenientes de escuela en Bachiller
	@PostMapping("/{nroExpediente}/actualizarExpedienteEscuela")
	public ResponseEntity<String> actualizarExpedienteEscuela(@PathVariable String nroExpediente,
			@RequestParam Long miembroId, @RequestParam Long presidenteId, @RequestBody Expediente expediente)
			throws NotFoundException {
		try {
			expedienteService.actualizarExpedienteEscuela(nroExpediente, miembroId, presidenteId, expediente);
			return ResponseEntity.ok("Campos actualizados exitosamente.");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar los campos", e);
		}
	}

	@PostMapping("/upload")
	public String uploadPDF(@RequestParam("file") MultipartFile file,
			@RequestParam("nroExpediente") String nroExpediente) {
		expedienteService.uploadPDFAndSetVersion1(nroExpediente, file);
		return "documentos/Expedientes/" + file.getOriginalFilename();
	}

	// OBTENER LA RUTA DE LA CARPETA DOCUMENTOS
	private Path obtenerRutaDocumentos() {
		Path documentosPath = Paths.get("documentos");
		return documentosPath.toAbsolutePath();
	}

	@PostMapping(value = "/registrar", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "http://localhost:5173")
	public Expediente subirExpediente(@RequestParam("pdf") MultipartFile pdf,
			@RequestParam("expediente") String expedienteJson) {
		try {
			byte[] pdfBytes = pdf.getBytes();

			// Genera un nombre único para el archivo
			String nombreArchivo = UUID.randomUUID().toString() + ".pdf";

			// Guarda el archivo en la carpeta "documentos"
			Path rutaArchivo = Paths.get("documentos", nombreArchivo);
			Files.write(rutaArchivo, pdfBytes);

			// Registro adicional
			System.out.println("Leyendo el archivo PDF: " + pdf.getOriginalFilename());
			System.out.println("Bytes del archivo PDF leídos: " + pdfBytes.length);
			System.out.println("Contenido de algunos bytes del archivo PDF: "
					+ Arrays.toString(Arrays.copyOfRange(pdfBytes, 0, 10)));

			// Parsea el JSON del expediente
			Expediente expediente = new ObjectMapper().readValue(expedienteJson, Expediente.class);

			// Guarda la ruta de archivo en la entidad Expediente
			expediente.setRutaDocumento(rutaArchivo.toString());

			return expedienteService.registerExpediente(expediente);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al leer los bytes del archivo PDF");
		}
	}

	@GetMapping("/{id}/version/{versionNumber}")
	@CrossOrigin(origins = "http://localhost:5173")
	public byte[] obtenerVersionDocumento(@PathVariable("id") Long id,
			@PathVariable("versionNumber") int versionNumber) {
		return expedienteService.findVersionByIdAndNumber(id, versionNumber);
	}

	// PARA EL PROCESO DE BACHILLER

}
