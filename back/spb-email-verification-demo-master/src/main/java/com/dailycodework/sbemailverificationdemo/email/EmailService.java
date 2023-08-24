package com.dailycodework.sbemailverificationdemo.email;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
    private JavaMailSender mailSender;

    public void sendEmail(List<String> to, String subject, String body, String pdfFilePath) {
    	System.out.println("mensaje para enviar al correo ");
    	try {
            for (String recipient : to) {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(recipient);
                helper.setSubject(subject);
                helper.setText(body);

                
                
             // Obtener el nombre del archivo del pdfFilePath
                Path path = Paths.get(pdfFilePath);
                String fileName = path.getFileName().toString();

                // Adjuntar el archivo PDF con su nombre original
                FileSystemResource file = new FileSystemResource(new File(pdfFilePath));
                helper.addAttachment(fileName, file);

                
                
                
                
                mailSender.send(message);
            }
        } catch (MessagingException e) {
            // Manejar cualquier excepción relacionada con el envío de correo
            e.printStackTrace();
        }
    }
}
