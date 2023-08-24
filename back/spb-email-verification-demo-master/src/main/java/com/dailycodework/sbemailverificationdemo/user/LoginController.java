package com.dailycodework.sbemailverificationdemo.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.sbemailverificationdemo.token.verification.login.TokenRequest;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {	
	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		try {
			// Validar las credenciales del usuario
			if (userService.validateCredentials(username, password)) {
				// Obtener el usuario por correo electrónico
				User user = userService.getUserByUsername(username);

				// Verificar si el usuario está verificado
				if (user.isEnabled()) {

					LoginToken loginToken = userService.generateLoginToken(user);
					String token = loginToken.getToken();

					// Obtener el nombre de usuario y el rol del usuario
					String userName = user.getFirstName() + " " + user.getLastName();
					String role = user.getRol().getId().toString();
					Long idUser = user.getId();

					// Crear el objeto LoginResponse con el token, nombre de usuario y rol
					LoginResponse loginResponse = new LoginResponse();
					loginResponse.setNombre(userName);
					loginResponse.setId(idUser);
					loginResponse.setToken(token);
					loginResponse.setUsername(username);
					loginResponse.setRole(role);

					// Devolver la respuesta al cliente (frontend) en formato JSON
					return ResponseEntity.ok(loginResponse);
				} else {
					// El usuario no está verificado
					String errorMessage = "El usuario no está verificado. Por favor, verifica tu cuenta.";
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(errorMessage));
				}
			} else {
				// Las credenciales no son válidas
				String errorMessage = "La contraseña o el correo son incorrectos.";
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(errorMessage));
			}
		} catch (Exception e) {
			// Manejar cualquier otra excepción que pueda ocurrir, incluida
			// UserNotVerifiedException
			String errorMessage = "Error al procesar la solicitud.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(errorMessage));
		}
	}
	@PostMapping("/validate-token")
	@CrossOrigin(origins = "http://localhost:5173")
	public ResponseEntity<String> validateLoginToken(@RequestBody TokenRequest tokenRequest) {
	    String token = tokenRequest.getToken();
	    System.out.println("Received token: " + token);

	    boolean isValid = userService.validateLoginToken(token);
	    boolean isNotExpired = userService.isLoginTokenNotExpired(token);

	    if (isValid && isNotExpired) {
	        return ResponseEntity.ok("Token is valid and not expired");
	    } else if (!isValid) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token has expired");
	    }
	}

}
