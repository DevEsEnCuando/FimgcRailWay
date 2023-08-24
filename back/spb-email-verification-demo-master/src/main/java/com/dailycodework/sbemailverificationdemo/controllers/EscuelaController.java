package com.dailycodework.sbemailverificationdemo.controllers;



import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.sbemailverificationdemo.entities.Escuela;
import com.dailycodework.sbemailverificationdemo.entities.PlanEstudios;
import com.dailycodework.sbemailverificationdemo.services.IEscuelaService;
import com.dailycodework.sbemailverificationdemo.services.IPlanEstudiosService;



@RestController
@RequestMapping("/api/escuela")
public class EscuelaController {
	
	@Autowired
	private IEscuelaService escuelaService;
	
	@Autowired
	private IPlanEstudiosService planEstudiosService;
	
	@RequestMapping("/planes")
	@ResponseBody
	public List<PlanEstudios> listarPlan(){
		return planEstudiosService.list();
	}
	
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:5173")
    public List<Escuela> listarEscuela() {
        return escuelaService.list();
    }
    
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Escuela> register(@RequestBody Escuela escuela) {
        Escuela nuevaEscuela = escuelaService.register(escuela);
        return new ResponseEntity<>(nuevaEscuela, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Escuela actualizarEscuela(@PathVariable("id") Long id, @RequestBody Escuela escuela) {
        return escuelaService.update(id, escuela);
    }
    
    
	@GetMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:5173")
	public ResponseEntity<List<Escuela>> list(){
		return new ResponseEntity<List<Escuela>>(escuelaService.list(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Escuela obtenerEscuelaPorID(@PathVariable("id") Long id) {
        return escuelaService.escuelaById(id);
    }
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Void> eliminarEscuela(@PathVariable Long id) {
		escuelaService.delete(id);
        return ResponseEntity.noContent().build();
    }
	@GetMapping("/{id}/planes")
	@CrossOrigin(origins = "http://localhost:5173")
    public List<PlanEstudios> listarPlanesPorIdEscuela(@PathVariable("id") Long id) {
        return planEstudiosService.listByEscuela(id);
    }
}
