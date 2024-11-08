package br.com.altaconstrucoesereformas.api.service;

import br.com.altaconstrucoesereformas.api.contact.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private ContactService contactService;

    @Test
    public void testSendEmail() {
        Contact contactEmail = new Contact("test@altaconstrucoes.com", "Subject", "Body");

        contactService.sendEmail(contactEmail);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@altaconstrucoes.com");
        message.setTo(contactEmail.to());
        message.setSubject(contactEmail.subject());
        message.setText(contactEmail.body());

        verify(mailSender).send(message);
    }
}
