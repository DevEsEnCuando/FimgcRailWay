package com.dailycodework.sbemailverificationdemo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dailycodework.sbemailverificationdemo.entities.Documento;
import com.dailycodework.sbemailverificationdemo.services.IDocumentoService;


@RestController
@RequestMapping("/api/documento")
@CrossOrigin(origins = "http://localhost:5173")
public class DocumentoController {

	@Autowired
	private IDocumentoService documentoService;
	
	
    // Endpoint para actualizar Version de expediente (Dictamen+MM+Expediente)
    @PostMapping("/{nroExpediente}/actualizarDictamen")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> actualizarDatosDictamen(@PathVariable String nroExpediente,@RequestBody Documento documento) throws NotFoundException {
    	try {
            documentoService.actualizarDatosDictamen(nroExpediente, documento);
            return ResponseEntity.ok("Campos actualizados exitosamente.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar los campos", e);
        }
    }
    
    // Endpoint para actualizar Version de expediente (Constancia+Dictamen+MM+Expediente)
    @PostMapping("/{nroExpediente}/actualizarConstancia")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> actualizarDatosConstancia(@PathVariable String nroExpediente,@RequestBody Documento documento) throws NotFoundException {
    	try {
            documentoService.actualizarDatosConstancia(nroExpediente, documento);
            return ResponseEntity.ok("Campos actualizados exitosamente.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar los campos", e);
        }
    }
    
    
    
	
    // Endpoint para actualizar Version de expediente (Dictamen+MM+Expediente)
    @PostMapping("/{nroExpediente}/actualizarSustentacion")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> actualizarSustentacion(@PathVariable String nroExpediente,@RequestParam Long secredocenteId, @RequestBody Documento documento) throws NotFoundException {
    	try {
            documentoService.actualizarSustentacion(nroExpediente, documento, secredocenteId);
            return ResponseEntity.ok("Campos actualizados exitosamente.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar los campos", e);
        }
    }
	
    // Endpoint para actualizar Version de expediente (Dictamen+MM+Expediente)
    @PostMapping("/{nroExpediente}/actualizarSesionCF")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> actualizarSesionCF(@PathVariable String nroExpediente,@RequestParam Date fechaSesionCF) throws NotFoundException {
    	try {
            documentoService.actualizarSesionCF(nroExpediente, fechaSesionCF);
            return ResponseEntity.ok("Campos actualizados exitosamente.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar los campos", e);
        }
    }
	
	
	
	
	
	
	
	
	
	
	/*	PARA IMPLEMENTAR LA DESCARGA MÁS ADELANTE
	 * import org.springframework.beans.factory.annotation.Autowired; import
	 * org.springframework.core.io.Resource; import
	 * org.springframework.core.io.UrlResource; import
	 * org.springframework.http.HttpHeaders; import
	 * org.springframework.http.MediaType; import
	 * org.springframework.http.ResponseEntity; import
	 * org.springframework.web.bind.annotation.GetMapping; import
	 * org.springframework.web.bind.annotation.PathVariable; import
	 * org.springframework.web.bind.annotation.RestController;
	 * 
	 * import java.io.IOException; import java.nio.file.Files; import
	 * java.nio.file.Path; import java.nio.file.Paths;
	 * 
	 * @RestController public class DocumentoController {
	 * 
	 * @Autowired private IDocumentoRepository documentoRepository;
	 * 
	 * // Ruta base donde se almacenan los archivos PDF private static final String
	 * PDF_BASE_PATH = "/ruta/para/almacenar/pdfs/";
	 * 
	 * @GetMapping("/descargar-pdf/{id}") public ResponseEntity<Resource>
	 * descargarPDF(@PathVariable Long id) throws IOException { // Obtener el
	 * documento por su ID desde la base de datos Documento documento =
	 * documentoRepository.findById(id).orElse(null);
	 * 
	 * if (documento != null) { // Obtener la ruta del archivo almacenado en el
	 * sistema de archivos String rutaArchivo = documento.getArchivopdfSF();
	 * 
	 * // Construir la ruta completa del archivo Path filePath =
	 * Paths.get(PDF_BASE_PATH, rutaArchivo);
	 * 
	 * // Verificar si el archivo existe en el sistema de archivos if
	 * (Files.exists(filePath)) { // Cargar el archivo en un recurso de Spring
	 * Resource resource = new UrlResource(filePath.toUri());
	 * 
	 * // Configurar el encabezado de la respuesta para la descarga del archivo
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
	 * resource.getFilename()); headers.setContentType(MediaType.APPLICATION_PDF);
	 * 
	 * // Devolver el archivo como respuesta return ResponseEntity.ok()
	 * .headers(headers) .body(resource); } else { // Manejar el caso si el archivo
	 * no existe // Enviar una respuesta de error 404 (Recurso no encontrado) return
	 * ResponseEntity.notFound().build(); } } else { // Manejar el caso si el
	 * documento no existe // Enviar una respuesta de error 404 (Recurso no
	 * encontrado) return ResponseEntity.notFound().build(); } } }
	 */
	
}
