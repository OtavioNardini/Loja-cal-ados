package br.unitins.topicos1.model;

import javax.persistence.Entity;

@Entity
public class Telefone  extends DefaultEntity{
    private Long id;
    private String codigoArea;
    private String numero;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigoArea() {
        return codigoArea;
    }
    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public static Telefone findById(Long id2) {
        return null;
    }
    public static Object findAll() {
        return null;
    }
    public void persist() {
    }

    
    
}
