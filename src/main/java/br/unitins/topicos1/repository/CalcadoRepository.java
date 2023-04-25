package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Calcado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class CalcadoRepository implements PanacheRepository<Calcado> {
    
    public List<Calcado> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }   
}
