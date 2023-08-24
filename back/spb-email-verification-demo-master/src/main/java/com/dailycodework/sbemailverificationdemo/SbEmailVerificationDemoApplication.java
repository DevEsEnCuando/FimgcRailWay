package com.dailycodework.sbemailverificationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.dailycodework.sbemailverificationdemo", "com.dailycodework.sbemailverificationdemo.event.listener"})
public class SbEmailVerificationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbEmailVerificationDemoApplication.class, args);
    }
    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("eliu.anaya.27@unsch.edu.pe");
        mailSender.setPassword("Tresagostoanayita5");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
        return mailSender;
    }
}

