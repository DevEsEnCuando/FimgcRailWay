package com.dailycodework.sbemailverificationdemo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	@Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        // Validar la solicitud si es necesario

        // Llamar al servicio para enviar el correo electrónico con el archivo adjunto
        emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody(), request.getPdfFilePath());

        return ResponseEntity.ok("Correo electrónico enviado exitosamente.");
    }
}
