package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;

public interface EnderecoService {
    
    // recursos basicos
    public List<EnderecoResponseDTO> getAll();

    public EnderecoResponseDTO findById(Long id);

    public EnderecoResponseDTO create(EnderecoDTO enderecoDTO);

    public EnderecoResponseDTO update(Long id, EnderecoDTO enderecoDTO);

    public void delete(Long id);

    // recursos extras

    public List<EnderecoResponseDTO> findByNome(String nome);

    public long count();
    
}
