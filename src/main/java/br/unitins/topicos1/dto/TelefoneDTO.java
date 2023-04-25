package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record TelefoneDTO(
    @NotBlank(message = "O campo codigo de area deve ser informado.")
    @Size(max = 2, message = "o codigo de area deve posssuir no máximo 2 caracteres.")
    String codigoArea,
    @NotBlank(message = "O campo numero deve ser informado.")
    @Size(max = 9, message = "o numero deve posssuir no máximo 9 caracteres.")
    String numero
) {
}
