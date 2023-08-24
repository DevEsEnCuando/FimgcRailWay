	package com.dailycodework.sbemailverificationdemo.registration;
	
	import com.dailycodework.sbemailverificationdemo.event.RegistrationCompleteEvent;
	import com.dailycodework.sbemailverificationdemo.event.listener.RegistrationCompleteEventListener;
	import com.dailycodework.sbemailverificationdemo.registration.token.VerificationToken;
	import com.dailycodework.sbemailverificationdemo.registration.token.IVerificationTokenRepository;
	import com.dailycodework.sbemailverificationdemo.user.User;
	import com.dailycodework.sbemailverificationdemo.user.UserServiceImpl;
	
	import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.Date;
	
	import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
	
	@RestController
	@RequiredArgsConstructor
	@RequestMapping("/register")
	public class RegistrationController {
	
	    private final UserServiceImpl userService;
	    private final ApplicationEventPublisher publisher;
	    private final IVerificationTokenRepository tokenRepository;
	
	    @PostMapping
	    public String registerUser(@RequestBody RegistrationRequest registrationRequest,final HttpServletRequest request) {
	        User user = userService.registerUser(registrationRequest);
	        String verificationLink = applicationUrl(request) + "/registro-completado?username=" + user.getUsername();
	        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
	        return "Registro exitoso!Ve a tu bandeja de entrad	a para completar tu registro";
	    }
	
	    @GetMapping("/verifyEmail")
	    public void verifyEmail(@RequestParam("token") String token, HttpServletResponse response) throws IOException {
	        VerificationToken theToken = tokenRepository.findByToken(token);

	        if (theToken == null) {
	            response.sendRedirect("http://localhost:5173/tokenExpirado");
	            return;
	        }

	        User user = theToken.getUser();

	        if (theToken.getExpirationTime().before(new Date())) {
	            // Eliminar el registro del correo si el token ha expirado y no se ha validado
	            if (!user.isEnabled()) {
	                userService.deleteUnverifiedUser(user.getUsername());
	            }
	            tokenRepository.delete(theToken); // Eliminar el token expirado
	            response.sendRedirect("http://localhost:5173/tokenExpirado");
	            return;
	        }

	        if (user.isEnabled()) {
	            response.sendRedirect("http://localhost:5173/verificadoExitoso");
	            return;
	        }

	        // Realizar la validación del token y habilitar al usuario
	        String verificationResult = userService.validateToken(token);

	        if (verificationResult.equalsIgnoreCase("valid")) {
	            response.sendRedirect("http://localhost:5173/verificadoExitoso");
	        } else {
	            response.sendRedirect("http://localhost:5173/token-invalido");
	        }
	    }
	    						
	    public String applicationUrl(HttpServletRequest request) {
	        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	    }
	}
