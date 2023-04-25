package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.topicos1.dto.CalcadoDTO;
import br.unitins.topicos1.dto.CalcadoResponseDTO;
import br.unitins.topicos1.model.Calcado;
import br.unitins.topicos1.model.Tamanho;
import br.unitins.topicos1.repository.CalcadoRepository;

@ApplicationScoped
public class CalcadoServiceImpl implements CalcadoService{
    
   

    @Inject
    CalcadoRepository calcadoRepository;

    @Inject
    Validator validator;

    @Override
    public List<CalcadoResponseDTO> getAll() {
        List<Calcado> list = calcadoRepository.listAll();
        return list.stream().map(CalcadoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CalcadoResponseDTO findById(Long id) {
        Calcado calcado = calcadoRepository.findById(id);
        if (calcado == null)
            throw new NotFoundException("Calçado não encontrada.");
        return new CalcadoResponseDTO(calcado);
    }

    @Override
    @Transactional
    public CalcadoResponseDTO create(CalcadoDTO calcadoDTO) throws ConstraintViolationException {
        validar(calcadoDTO);

        Calcado entity = new Calcado();
        entity.setMarca(calcadoDTO.marca());
        entity.setModelo(calcadoDTO.modelo());
        entity.setTamanho(Tamanho.valueOf(calcadoDTO.tamanho()));

        calcadoRepository.persist(entity);

        return new CalcadoResponseDTO(entity);
    }

    @Override
    @Transactional
    public CalcadoResponseDTO update(Long id, CalcadoDTO calcadoDTO) throws ConstraintViolationException{
        validar(calcadoDTO);
   
        Calcado entity = calcadoRepository.findById(id);
        entity.setDescricao(calcadoDTO.descricao());
        entity.setNome(calcadoDTO.nome());
        entity.setTamanho(Tamanho.valueOf(calcadoDTO.tamanho()));

        return new CalcadoResponseDTO(entity);
    }

    private void validar(CalcadoDTO calcadoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CalcadoDTO>> violations = validator.validate(calcadoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }

    @Override
    @Transactional
    public void delete(Long id) {
        calcadoRepository.deleteById(id);
    }

    @Override
    public List<CalcadoResponseDTO> findByNome(String nome) {
        List<Calcado> list = calcadoRepository.findByNome(nome);
        return list.stream().map(CalcadoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return calcadoRepository.count();
    }
    
}
