package br.unitins.topicos1.model;

import javax.persistence.Entity;



@Entity
public class Endereco extends  DefaultEntity {
    private Long id;
 private Boolean principal;
 private String logradouro;
 private String bairro;
 private String numero;
 private String complemento;
 private String cep;
 private String municipio;
 private String estado;
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Boolean getPrincipal() {
    return principal;
}
public void setPrincipal(Boolean principal) {
    this.principal = principal;
}
public String getLogradouro() {
    return logradouro;
}
public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
}
public String getBairro() {
    return bairro;
}
public void setBairro(String bairro) {
    this.bairro = bairro;
}
public String getNumero() {
    return numero;
}
public void setNumero(String numero) {
    this.numero = numero;
}
public String getComplemento() {
    return complemento;
}
public void setComplemento(String complemento) {
    this.complemento = complemento;
}
public String getCep() {
    return cep;
}
public void setCep(String cep) {
    this.cep = cep;
}
public String getMunicipio() {
    return municipio;
}
public void setMunicipio(String municipio) {
    this.municipio = municipio;
}
public String getEstado() {
    return estado;
}
public void setEstado(String estado) {
    this.estado = estado;
}
public static Endereco findById(Long id2) {
    return null;
}
public void persist() {
}
public static Object findAll() {
    return null;
}

 
}
