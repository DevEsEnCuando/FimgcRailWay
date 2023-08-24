package com.dailycodework.sbemailverificationdemo.reset.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;



@Service
public class EmailServicePassReset {

	private final JavaMailSender mailSender;

    @Autowired
    public EmailServicePassReset(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        MimeMessage correo = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(correo, "utf-8");

        try {
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(mensaje, true); // Configura el mensaje como HTML
            mailSender.send(correo);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Maneja la excepción aquí
        }
    }
}
