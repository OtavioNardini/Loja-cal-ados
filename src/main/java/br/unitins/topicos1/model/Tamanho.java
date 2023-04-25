package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Tamanho {
    TAMANHO35(1,"Tamanho 35"),
    TAMANHO36(1,"Tamanho 36"),
    TAMANHO37(1,"Tamanho 37"),
    TAMANHO38(1,"Tamanho 38"),
    TAMANHO39(1,"Tamanho 39"),
    TAMANHO40(1,"Tamanho 40"),
    TAMANHO41(1,"Tamanho 41"),
    TAMANHO42(1,"Tamanho 42"),
    TAMANHO43(1,"Tamanho 43"),
    TAMANHO44(1,"Tamanho 44"),
    TAMANHO45(1,"Tamanho 45"),
    TAMANHO46(1,"Tamanho 46"),
    TAMANHO47(1,"Tamanho 47");

    
    private int id;
    private String label;

    Tamanho(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Tamanho valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(Tamanho tamanho : Tamanho.values()) {
            if (id.equals(tamanho.getId()))
                return tamanho;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
    
}
