package br.unitins.topicos1.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Calcado extends Produto {
    private String marca;
    private String modelo;
    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto praduto) {
        this.produto = praduto;
    }
    public Tamanho getTamanho() {
        return tamanho;
    }
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }


}
