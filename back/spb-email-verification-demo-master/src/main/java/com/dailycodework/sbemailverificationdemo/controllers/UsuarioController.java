//package com.dailycodework.sbemailverificationdemo.controllers;
//
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dailycodework.sbemailverificationdemo.entities.Usuario;
//import com.dailycodework.sbemailverificationdemo.services.IUsuarioService;
//
//@RestController
//@RequestMapping("/api/usuario")
//
//public class UsuarioController {
//	@Autowired
//	private IUsuarioService estudianteService;
//	
//	@GetMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Usuario>> listarUsuarios(){
//		return new ResponseEntity<List<Usuario>>(estudianteService.listarUsuarios(),HttpStatus.OK);
//	}
//	
//	@PostMapping(value="/register", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Usuario> register(@RequestBody Usuario entity ){
//		return new ResponseEntity<Usuario>(estudianteService.register(entity),HttpStatus.OK);
//	}
//	
//	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario entity ){
//		return new ResponseEntity<Usuario>(estudianteService.updateUsuario(entity),HttpStatus.OK);
//	}
//	
//	
//	@GetMapping(value="/findUsuarioById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") Long id){
//		return new ResponseEntity<Usuario>(estudianteService.findUsuarioById(id),HttpStatus.OK);
//	}
//	
//	@GetMapping(value="/findUsuarioByUsername/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Usuario> findUsuarioByUsername(@PathVariable("username")String username){
//		return new ResponseEntity<Usuario>(estudianteService.findUsuarioByUsername(username),HttpStatus.OK);
//	}
//	
//	@GetMapping(value="/findUsuarioByEscuela/{escuela_id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Usuario>> findUsuarioByEscuela(@PathVariable("escuela_id")Long escuela_id){
//		return new ResponseEntity<List<Usuario>>(estudianteService.findUsuarioByEscuela(escuela_id),HttpStatus.OK);
//	}
//	
//	
//	
//	//J-verificar docentes
//	
//
//    @GetMapping("/verificarDocentes")
//    public List<Usuario> getUsersByRoleId(@RequestParam Long roleId) {
//        return estudianteService.getUsersByRoleId(roleId);
//    }
//    
//    @GetMapping("/buscarDocentes")
//    public List<Usuario> buscarDocentesPorNombre(@RequestParam String nombre) {
//        return estudianteService.buscarDocentesPorNombre(nombre,2L);
//    }
//}
