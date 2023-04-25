package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(
String nome,
String email,
String senha,
String cpf,
Telefone celular,
Telefone whatsapp


) 
{
    public UsuarioResponseDTO(Usuario usuario) {
        this( usuario.getNome(), usuario.getEmail(),usuario.getSenha(), 
        usuario.getCpf(), usuario.getCelular(),usuario.getWhatsapp()); 
    }
}
