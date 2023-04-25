package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Endereco;

public record EnderecoResponseDTO(
    Boolean principal,
    String logradouro,
    String bairro,
    String numero,
    String complemento,
    String cep,
    String municipio,
    String estado
) {
    public EnderecoResponseDTO(Endereco endereco) {
        this( endereco.getPrincipal(), endereco.getLogradouro(),endereco.getBairro(),endereco.getNumero(),
        endereco.getComplemento(),endereco.getCep(),endereco.getMunicipio(),endereco.getEstado()); 
    }
}
