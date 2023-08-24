package com.dailycodework.sbemailverificationdemo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.sbemailverificationdemo.entities.TipoDocumento;
import com.dailycodework.sbemailverificationdemo.services.ITipoDocumentoService;



@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoController {
    @Autowired
    private ITipoDocumentoService tipoDocumentoService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<TipoDocumento> listarTipoDocumentos() {
        return tipoDocumentoService.list();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public TipoDocumento crearTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.register(tipoDocumento);
    }
    @DeleteMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Void> deleteTipoDocumento(@PathVariable Long id) {
        tipoDocumentoService.deleteTipoDocumento(id);
        return ResponseEntity.noContent().build();
    }

	/*
	 * @GetMapping("/{id}") public TipoDocumento
	 * obtenerTipoDocumento(@PathVariable("id") Long id) { return
	 * tipoDocumentoService.findTipoDocumentoById(id); }
	 * 
	 * @GetMapping("/{id}") public TipoDocumento
	 * obtenerTipoDocumentoByName(@PathVariable("id") Long id) { return
	 * tipoDocumentoService.findTipoDocumentoByName(String nombre); }
	 */
    
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public TipoDocumento actualizarTipoDocumento(@PathVariable("id") Long id, @RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.update(id, tipoDocumento);
    }

}
