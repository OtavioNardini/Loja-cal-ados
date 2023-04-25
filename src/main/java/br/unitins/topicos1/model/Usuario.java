package br.unitins.topicos1.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Usuario extends  DefaultEntity{


    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 2)
    private String cpf;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 60)
    private String senha;

    private Telefone celular;

    public Telefone getCelular() {
        return celular;
    }

    public void setCelular(Telefone celular) {
        this.celular = celular;
    }

    private Telefone Whatsapp;

    public Telefone getWhatsapp() {
        return Whatsapp;
    }

    public void setWhatsapp(Telefone whatsapp) {
        Whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static Object findAll() {
        return null;
    }

    public static Usuario findById(Long id2) {
        return null;
    }
}
