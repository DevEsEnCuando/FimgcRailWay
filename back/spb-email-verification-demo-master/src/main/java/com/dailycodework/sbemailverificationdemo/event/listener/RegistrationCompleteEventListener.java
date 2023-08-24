package com.dailycodework.sbemailverificationdemo.event.listener;

import com.dailycodework.sbemailverificationdemo.event.RegistrationCompleteEvent;
import com.dailycodework.sbemailverificationdemo.user.User;
import com.dailycodework.sbemailverificationdemo.user.UserServiceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
	private UserServiceImpl userService;
    private JavaMailSender mailSender;
    private User theUser;
    private String applicationUrl;
    private String url;

    public RegistrationCompleteEventListener(JavaMailSender mailSender, UserServiceImpl userService) {
        this.mailSender = mailSender;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. Get the newly registered user
        theUser = event.getUser();
        // 2. Create a verification token for the user
        String verificationToken = UUID.randomUUID().toString();
        // 3. Save the verification token for the user
        userService.saveUserVerificationToken(theUser, verificationToken);
        // 4. Set the application URL
        applicationUrl = event.getApplicationUrl();
        // 5. Build the verification URL to be sent to the user
        url = applicationUrl + "/register/verifyEmail?token=" + verificationToken;
        // 6. Send the email.
        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendVerificationEmail(String recipientEmail) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email Verification";
        String senderName = "Portal de registro de la Facultad de Ingenieria de Minas,Geologia y Civil";
        String mailContent = "<p> Hola, " + theUser.getFirstName() + ", </p>" +
                "<p>Te acabas de registrar en el sistema de gestion documentaria de la facultad," + "" +
                "Dale click al enlace para que puedas completar tu registro.</p>" +
                "<a href=\"" + url + "\">Verifica en tu correo institucional para verificar tu cuenta</a>" +
                "<p> Gracias <br> Portal de registro de usuarios";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("eliu.anaya.27@unsch.edu.pe", senderName);
        messageHelper.setTo(theUser.getUsername());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
    public void resendVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException {
        String verificationToken = UUID.randomUUID().toString();
        userService.saveUserVerificationToken(user, verificationToken);
        String resendUrl = applicationUrl + "/register/verifyEmail?token=" + verificationToken;

        try {
            sendVerificationEmail(resendUrl);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    // Getter and Setter methods for theUser, userService, and mailSender
    public User getTheUser() {
        return theUser;
    }

    public void setTheUser(User theUser) {
        this.theUser = theUser;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
