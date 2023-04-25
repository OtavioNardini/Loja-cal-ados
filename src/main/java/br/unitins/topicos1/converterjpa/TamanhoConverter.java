package br.unitins.topicos1.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.topicos1.model.Tamanho;

@Converter(autoApply = true)
public class TamanhoConverter implements AttributeConverter<Tamanho, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Tamanho tamanho) {
        return tamanho == null ? null : tamanho.getId();
    }

    @Override
    public Tamanho convertToEntityAttribute(Integer id) {
        return Tamanho.valueOf(id);
    }
    
}
