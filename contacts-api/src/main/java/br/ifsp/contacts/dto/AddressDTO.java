package br.ifsp.contacts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO de endereço")
public class AddressDTO {

    @Schema(description = "ID do endereço", example = "1")
    private Long id;

    @NotBlank
    @Schema(description = "Rua", example = "Rua das Flores")
    private String rua;

    @Schema(description = "Número", example = "123")
    private String numero;

    @Schema(description = "Bairro", example = "Centro")
    private String bairro;

    @NotBlank
    @Schema(description = "Cidade", example = "Guarulhos")
    private String cidade;

    @NotBlank
    @Schema(description = "Estado", example = "SP")
    private String estado;

    @Schema(description = "CEP", example = "07000-000")
    private String cep;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}