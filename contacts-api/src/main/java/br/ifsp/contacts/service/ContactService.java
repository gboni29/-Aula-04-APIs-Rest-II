package br.ifsp.contacts.service;

import br.ifsp.contacts.dto.ContactDTO;
import br.ifsp.contacts.mapper.AddressMapper;
import br.ifsp.contacts.mapper.ContactMapper;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Page<ContactDTO> getAllContacts(Pageable pageable) {
        return contactRepository.findAll(pageable).map(ContactMapper::toDTO);
    }

    public ContactDTO getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        return ContactMapper.toDTO(contact);
    }

    public ContactDTO createContact(ContactDTO dto) {
        Contact contact = ContactMapper.toEntity(dto);
        Contact saved = contactRepository.save(contact);
        return ContactMapper.toDTO(saved);
    }

    public ContactDTO updateContact(Long id, ContactDTO dto) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contact.setNome(dto.getNome());
        contact.setEmail(dto.getEmail());
        contact.setTelefone(dto.getTelefone());
        contact.setAddress(AddressMapper.toEntity(dto.getAddress()));

        Contact updated = contactRepository.save(contact);
        return ContactMapper.toDTO(updated);
    }

    public void deleteContact(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        contactRepository.delete(contact);
    }
}