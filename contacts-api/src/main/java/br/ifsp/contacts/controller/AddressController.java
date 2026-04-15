package br.ifsp.contacts.controller;

import br.ifsp.contacts.dto.AddressDTO;
import br.ifsp.contacts.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Operation(summary = "Listar endereços", description = "Retorna uma lista paginada de endereços")
    @GetMapping
    public Page<AddressDTO> getAllAddresses(
            @Parameter(description = "Paginação e ordenação")
            @PageableDefault(size = 10, sort = "cidade") Pageable pageable) {
        return addressService.getAllAddresses(pageable);
    }

    @Operation(summary = "Buscar endereço por ID")
    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @Operation(summary = "Criar endereço")
    @PostMapping
    public AddressDTO createAddress(@RequestBody @Valid AddressDTO dto) {
        return addressService.createAddress(dto);
    }

    @Operation(summary = "Atualizar endereço")
    @PutMapping("/{id}")
    public AddressDTO updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO dto) {
        return addressService.updateAddress(id, dto);
    }

    @Operation(summary = "Deletar endereço")
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}