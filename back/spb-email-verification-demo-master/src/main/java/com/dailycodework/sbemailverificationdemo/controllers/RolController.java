package com.dailycodework.sbemailverificationdemo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.dailycodework.sbemailverificationdemo.entities.Rol;
import com.dailycodework.sbemailverificationdemo.services.IRolService;

@RestController
@RequestMapping("/api/rol")

public class RolController {
	@Autowired
	private IRolService rolService;

	
	@GetMapping("/roles")
	@CrossOrigin(origins = "http://localhost:5173")
    public List<Rol> listarRol() {
        return rolService.list();
    }
	
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public Rol crearRol(@RequestBody Rol rol) {
        return rolService.register(rol);
    }
    
    @DeleteMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Rol actualizarRol(@PathVariable("id") Long id, @RequestBody Rol rol) {
        return rolService.update(id, rol);
    }
}
