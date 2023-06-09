package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class ProdutoRepository implements PanacheRepository<Produto> {
    
    public List<Produto> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
    
    
}
