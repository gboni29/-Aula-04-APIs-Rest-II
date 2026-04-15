package br.ifsp.contacts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO de contato")
public class ContactDTO {

    @Schema(description = "ID do contato", example = "1")
    private Long id;

    @NotBlank
    @Schema(description = "Nome do contato", example = "Gustavo")
    private String nome;

    @Email
    @NotBlank
    @Schema(description = "Email do contato", example = "gustavo@email.com")
    private String email;

    @Schema(description = "Telefone do contato", example = "11999999999")
    private String telefone;

    @Valid
    @Schema(description = "Endereço do contato")
    private AddressDTO address;

    public ContactDTO() {
    }

    public ContactDTO(Long id, String nome, String email, String telefone, AddressDTO address) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}