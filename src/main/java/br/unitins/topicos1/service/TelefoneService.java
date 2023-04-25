package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;

public interface TelefoneService {
            // recursos basicos
            public List<TelefoneResponseDTO> getAll();

            public TelefoneResponseDTO findById(Long id);
        
            public TelefoneResponseDTO create(TelefoneDTO telefoneDTO);
        
            public TelefoneResponseDTO update(Long id, TelefoneDTO telefoneDTO);
        
            public void delete(Long id);
        
            // recursos extras
        
            public List<TelefoneResponseDTO> findByNome(String nome);
        
            public long count();
    
}
