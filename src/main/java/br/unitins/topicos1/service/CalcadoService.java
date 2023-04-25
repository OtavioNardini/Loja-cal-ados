package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CalcadoDTO;
import br.unitins.topicos1.dto.CalcadoResponseDTO;

public interface CalcadoService {
    // recursos basicos
    public List<CalcadoResponseDTO> getAll();

    public CalcadoResponseDTO findById(Long id);

    public CalcadoResponseDTO create(CalcadoDTO calcadoDTO);

    public CalcadoResponseDTO update(Long id, CalcadoDTO calcadoDTO);

    public void delete(Long id);

    // recursos extras

    public List<CalcadoResponseDTO> findByNome(String nome);

    public long count();
    
}
