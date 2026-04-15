package br.ifsp.contacts.controller;

import br.ifsp.contacts.dto.ContactDTO;
import br.ifsp.contacts.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Operation(summary = "Listar contatos", description = "Retorna uma lista paginada de contatos")
    @GetMapping
    public Page<ContactDTO> getAllContacts(
            @Parameter(description = "Paginação e ordenação")
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return contactService.getAllContacts(pageable);
    }

    @Operation(summary = "Buscar contato por ID")
    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @Operation(summary = "Criar contato")
    @PostMapping
    public ContactDTO createContact(@RequestBody @Valid ContactDTO dto) {
        return contactService.createContact(dto);
    }

    @Operation(summary = "Atualizar contato")
    @PutMapping("/{id}")
    public ContactDTO updateContact(@PathVariable Long id, @RequestBody @Valid ContactDTO dto) {
        return contactService.updateContact(id, dto);
    }

    @Operation(summary = "Deletar contato")
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}