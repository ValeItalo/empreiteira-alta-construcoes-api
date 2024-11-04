package br.com.altaconstrucoesereformas.api.controller;

import br.com.altaconstrucoesereformas.api.contact.Contact;
import br.com.altaconstrucoesereformas.api.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> saveContact(@RequestBody Contact contato) {
        System.out.println(contato);

        try {
            contactService.sendEmail(contato);
            return ResponseEntity.status(HttpStatus.OK).body("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao enviar o email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao enviar a mensagem. Tente novamente mais tarde.");
        }
    }

    @GetMapping("/contact")
    public ResponseEntity<String> getContact(@RequestBody Contact contato) {
        System.out.println("API OK");

        try {
            contactService.sendEmail(contato);
            return ResponseEntity.status(HttpStatus.OK).body("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao enviar o email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao enviar a mensagem. Tente novamente mais tarde.");
        }

        }
}
