package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.unitins.topicos1.model.Telefone;

public record UsuarioDTO(
    @NotBlank(message = "O campo nome deve ser informado.")
    String nome,
    String email,
    String senha,
    
    @NotBlank(message = "O campo cpf deve ser informado.")
    @Size(max = 14, message = "o cpf deve posssuir no máximo 14 caracteres.")
    String cpf,

    Telefone celular,
    Telefone whatsapp
) 
{  
}
