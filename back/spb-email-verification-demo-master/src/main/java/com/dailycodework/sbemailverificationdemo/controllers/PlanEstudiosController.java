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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.sbemailverificationdemo.entities.PlanEstudios;
import com.dailycodework.sbemailverificationdemo.services.IPlanEstudiosService;



@RestController
@RequestMapping("/api/plan")
public class PlanEstudiosController {
	@Autowired
	private IPlanEstudiosService planEstudiosService;
	
	
	
	@GetMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:5173")
	 public List<PlanEstudios> listarPlanes() {
        return planEstudiosService.list();
    }

    @PostMapping(value = "/registrar", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:5173")
    public PlanEstudios crearPlan(@RequestBody PlanEstudios planEstudios) {
        return planEstudiosService.register(planEstudios);
        
    }

    
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public PlanEstudios actualizarPlan (@PathVariable("id") Long id, @RequestBody PlanEstudios planEstudios) {
        return planEstudiosService.update(id, planEstudios);
    }
    @DeleteMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Void> eliminarPlan(@PathVariable Long id) {
		planEstudiosService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<PlanEstudios> getPlanById(@PathVariable Long id) {
        PlanEstudios plan = planEstudiosService.findPlanById(id);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
