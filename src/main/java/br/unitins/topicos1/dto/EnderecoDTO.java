package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record EnderecoDTO(
    Boolean principal,
    @NotBlank(message = "O campo logradouro deve ser informado.")
    String logradouro,
    @NotBlank(message = "O campo bairro deve ser informado.")
    String bairro,
    @NotBlank(message = "O campo numero deve ser informado.")
    String numero,
    @NotBlank(message = "O campo complemento deve ser informado.")
    String complemento,
    @NotBlank(message = "O campo cep deve ser informado.")
    @Size(max = 8, message = "o cep deve posssuir no máximo 8 caracteres.")
    String cep,
    @NotBlank(message = "O campo municipio deve ser informado.")
    String municipio,
    @NotBlank(message = "O campo estado deve ser informado.")
    String estado
) {

    
}
