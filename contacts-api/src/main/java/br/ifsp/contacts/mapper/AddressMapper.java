package br.ifsp.contacts.mapper;

import br.ifsp.contacts.dto.AddressDTO;
import br.ifsp.contacts.model.Address;

public class AddressMapper {

    public static AddressDTO toDTO(Address address) {
        if (address == null) {
            return null;
        }

        return new AddressDTO(
                address.getId(),
                address.getRua(),
                address.getNumero(),
                address.getBairro(),
                address.getCidade(),
                address.getEstado(),
                address.getCep()
        );
    }

    public static Address toEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Address(
                dto.getId(),
                dto.getRua(),
                dto.getNumero(),
                dto.getBairro(),
                dto.getCidade(),
                dto.getEstado(),
                dto.getCep()
        );
    }
}