package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneResponseDTO(
    String codigoarea,
    String numero

) {
    public TelefoneResponseDTO(Telefone telefone) {
        this( telefone.getCodigoArea(), telefone.getNumero()); 
    } 
}
