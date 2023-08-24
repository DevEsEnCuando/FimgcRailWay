package com.dailycodework.sbemailverificationdemo.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.sbemailverificationdemo.registration.RegistrationRequest;
import com.dailycodework.sbemailverificationdemo.reset.password.UpdatePasswordRequest;

import lombok.RequiredArgsConstructor;

/**
 * @author Sampson Alfred
 */
@RestController

@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	@Autowired
    private  IUserService userService;

    @GetMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:5173")
	public ResponseEntity<List<User>> list(){
		return new ResponseEntity<List<User>>(userService.list(),HttpStatus.OK);
	}
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
        // Aquí puedes realizar la lógica de registro del usuario y guardar los datos en la base de datos
        // Puedes acceder a los datos del formulario a través del objeto RegistrationRequest
        // Retorna una ResponseEntity con un mensaje de éxito o error según sea necesario
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
    
		    @PostMapping(value = "/login-token", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<LoginToken> generateLoginToken() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        User currentUser = (User) authentication.getPrincipal();

	        LoginToken loginToken = userService.generateLoginToken(currentUser);

	        return new ResponseEntity<>(loginToken, HttpStatus.OK);
	    }
    
    //Lo de usuario
    
    @PostMapping(value="/registrar", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> register(@RequestBody User entity ){
		return new ResponseEntity<User>(userService.register(entity),HttpStatus.OK);
	}
	
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUsuario(@RequestBody User entity ){
		return new ResponseEntity<User>(userService.updateUsuario(entity),HttpStatus.OK);
	}
	
	
		@GetMapping(value="/findUsuarioById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
		@CrossOrigin(origins = "http://localhost:5173")
		public ResponseEntity<User> findUsuarioById(@PathVariable Long id){
			return new ResponseEntity<User>(userService.obtenerUsuarioPorId(id),HttpStatus.OK);
		}
	
	@GetMapping(value="/findUsuarioByUsername/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUsuarioByFirstName(@PathVariable("username")String firstName){
		return new ResponseEntity<User>(userService.findUsuarioByFirstName(firstName),HttpStatus.OK);
	}
	
	@GetMapping(value="/findUsuarioByEscuela/{escuela_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findUsuarioByEscuela(@PathVariable("escuela_id")Long escuela_id){
		return new ResponseEntity<List<User>>(userService.findUsuarioByEscuela(escuela_id),HttpStatus.OK);
	}
	
	
	
	//J-verificar docentes
	

    @GetMapping("/verificarDocentes")
    public List<User> getUsersByRoleId(@RequestParam Long roleId) {
        return userService.getUsersByRoleId(roleId);
    }
    
    @GetMapping("/buscarDocentes")
	@CrossOrigin(origins = "http://localhost:5173")
    public List<User> buscarDocentesPorNombre(@RequestParam String firstName) {
        return userService.buscarDocentesPorNombre(firstName,3L);
    }
    @PutMapping("/{username}/update-password")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> updateUserPassword(@PathVariable String username, @RequestBody UpdatePasswordRequest request) {
        User updatedUser = userService.updateUserPasswordByUsername(username, request.getNewPassword());
        return ResponseEntity.ok("Contraseña actualizada con éxito para el usuario: " + updatedUser.getUsername());
    }
     
}

