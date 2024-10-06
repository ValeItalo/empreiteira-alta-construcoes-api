package br.com.altaconstrucoesereformas.api.controller;

import br.com.altaconstrucoesereformas.api.contact.Contact;
import br.com.altaconstrucoesereformas.api.service.ContactService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contato")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public void saveContact(@RequestBody Contact contato) {
        System.out.println(contato);

        contactService.sendEmail(contato);
    }

}
