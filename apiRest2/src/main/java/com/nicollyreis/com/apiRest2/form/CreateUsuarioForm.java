package com.nicollyreis.com.apiRest2.form;

import com.nicollyreis.com.apiRest2.model.Usuario;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateUsuarioForm {
    @Nonnull
    private String nome;

    @Nonnull
    @Column(unique = true)
    private String email;

    @Nonnull
    @Column(unique = true)
    private String login;

    @Nonnull
    @Column(unique = true)
    private String senha;

    //conversão do form pra model
    public Usuario convert(){

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        return usuario;
    }

    public Usuario update(Usuario usuario){
        usuario.setNome(this.getNome());
        usuario.setEmail(this.getEmail());
        usuario.setLogin(this.getLogin());
        usuario.setSenha(this.getSenha());

        return usuario;
    }

}
