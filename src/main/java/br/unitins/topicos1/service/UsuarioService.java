package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;

public interface UsuarioService {
        // recursos basicos
        public List<UsuarioResponseDTO> getAll();

        public UsuarioResponseDTO findById(Long id);
    
        public UsuarioResponseDTO create(UsuarioDTO usuarioDTO);
    
        public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO);
    
        public void delete(Long id);
    
        // recursos extras
    
        public List<UsuarioResponseDTO> findByNome(String nome);
    
        public long count();
    
}
