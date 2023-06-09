package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.TelefoneRepository;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {
    
    @Inject
    TelefoneRepository telefoneRepository;

    @Inject
    Validator validator;
    
    @Override
    public List<TelefoneResponseDTO> getAll(){
        List<Telefone> list = telefoneRepository.listAll();
        return list.stream().map(TelefoneResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public TelefoneResponseDTO findById(Long id) {
        Telefone telefone = telefoneRepository.findById(id);
        if (telefone == null)
            throw new NotFoundException("Telefone não encontrado.");
        return new TelefoneResponseDTO(telefone);
    }

    @Override
    @Transactional
    public TelefoneResponseDTO create(TelefoneDTO telefoneDTO) throws ConstraintViolationException {
        validar(telefoneDTO);

        Telefone entity = new Telefone();
        entity.setCodigoArea(telefoneDTO.codigoArea());
        entity.setNumero(telefoneDTO.numero());
        telefoneRepository.persist(entity);

        return new TelefoneResponseDTO(entity);
    }

    @Override
    @Transactional
    public TelefoneResponseDTO update(Long id, TelefoneDTO telefoneDTO) throws ConstraintViolationException{
        validar(telefoneDTO);
   
        Telefone entity = telefoneRepository.findById(id);
        entity.setCodigoArea(telefoneDTO.codigoArea());
        entity.setNumero(telefoneDTO.numero());
;

        return new TelefoneResponseDTO(entity);
    }

    private void validar(TelefoneDTO telefoneDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<TelefoneDTO>> violations = validator.validate(telefoneDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }

    @Override
    @Transactional
    public void delete(Long id) {
        telefoneRepository.deleteById(id);
    }

    @Override
    public List<TelefoneResponseDTO> findByNome(String nome) {
        List<Telefone> list = telefoneRepository.findByNome(nome);
        return list.stream().map(TelefoneResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return telefoneRepository.count();
    }
    
}
