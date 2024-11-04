package br.com.altaconstrucoesereformas.api.service;

import br.com.altaconstrucoesereformas.api.contact.Contact;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final JavaMailSender mailSender;

    public ContactService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Contact contactEmail) {
        var message = new SimpleMailMessage();
        message.setText(contactEmail.body());
        message.setFrom("noreply@altaconstrucoes.com");
        message.setTo(contactEmail.to());
        message.setSubject(contactEmail.subject());
        mailSender.send(message);
    }
}