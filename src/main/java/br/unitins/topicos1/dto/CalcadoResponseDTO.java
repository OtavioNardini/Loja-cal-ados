package br.unitins.topicos1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.topicos1.model.Calcado;
import br.unitins.topicos1.model.Tamanho;

public record CalcadoResponseDTO(
    String descricao,
    String nome,
    Double preco,
    Integer estoque,
    String marca,
    String modelo,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Tamanho tamanho


)
 {
    public CalcadoResponseDTO(Calcado calcado) {
        this( calcado.getDescricao(), calcado.getNome(), 
         calcado.getPreco(),calcado.getEstoque(), calcado.getModelo(),calcado.getMarca(), calcado.getTamanho()); 
    }
}