package br.ifsp.contacts.service;

import br.ifsp.contacts.dto.AddressDTO;
import br.ifsp.contacts.mapper.AddressMapper;
import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Page<AddressDTO> getAllAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable).map(AddressMapper::toDTO);
    }

    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        return AddressMapper.toDTO(address);
    }

    public AddressDTO createAddress(AddressDTO dto) {
        Address address = AddressMapper.toEntity(dto);
        Address saved = addressRepository.save(address);
        return AddressMapper.toDTO(saved);
    }

    public AddressDTO updateAddress(Long id, AddressDTO dto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        address.setRua(dto.getRua());
        address.setNumero(dto.getNumero());
        address.setBairro(dto.getBairro());
        address.setCidade(dto.getCidade());
        address.setEstado(dto.getEstado());
        address.setCep(dto.getCep());

        Address updated = addressRepository.save(address);
        return AddressMapper.toDTO(updated);
    }

    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        addressRepository.delete(address);
    }
}