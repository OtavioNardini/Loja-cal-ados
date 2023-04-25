package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record CalcadoDTO(
    @NotBlank(message = "O campo descrição deve ser informado.")
    @Size(max = 120, message = "a descrição deve posssuir no máximo 120 caracteres.")
    String descricao,
String marca,
String modelo,
    Integer estoque,
    Double preco,
    Integer tamanho,

    @NotBlank(message = "O campo nome deve ser informado.")
    String nome

)
{    
}
