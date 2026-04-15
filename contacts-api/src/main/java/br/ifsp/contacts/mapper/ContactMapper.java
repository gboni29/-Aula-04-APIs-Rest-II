package br.ifsp.contacts.mapper;

import br.ifsp.contacts.dto.ContactDTO;
import br.ifsp.contacts.model.Contact;

public class ContactMapper {

    public static ContactDTO toDTO(Contact contact) {
        if (contact == null) {
            return null;
        }

        return new ContactDTO(
                contact.getId(),
                contact.getNome(),
                contact.getEmail(),
                contact.getTelefone(),
                AddressMapper.toDTO(contact.getAddress())
        );
    }

    public static Contact toEntity(ContactDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Contact(
                dto.getId(),
                dto.getNome(),
                dto.getEmail(),
                dto.getTelefone(),
                AddressMapper.toEntity(dto.getAddress())
        );
    }
}