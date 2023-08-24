package com.dailycodework.sbemailverificationdemo.reset.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailResetPassController {

    private final EmailServicePassReset emailService;
    
    @Autowired
    public EmailResetPassController(EmailServicePassReset emailService) {
        this.emailService = emailService;  
    }

    @PostMapping("/enviar-correo")
    public String enviarCorreo(@RequestBody CorreoRequest request) {
        String destinatario = request.getDestinatario();

        // Construir el enlace a la interfaz de ReactJS
        String enlaceInterfaz = "http://localhost:5173/resetPassword";  // Cambia esto al enlace correcto
        String mensaje = "Si solicitaste el cambio de tu contraseña en el sistema de la Facultad de Ingenieria de Minas,Geologia y Civil, haz click <a href='" + enlaceInterfaz + "'>aquí</a> para cambiar tu contraseña.";

        // Agregar un atributo adicional para permitir HTML en el correo
        String mensajeConHTML = "<html><body>" + mensaje + "</body></html>";

        // Enviar el correo con el enlace clickeable
        emailService.enviarCorreo(destinatario, "Solicitud de cambio de contraseña", mensajeConHTML);

        return "Correo enviado con éxito";
    }
}

