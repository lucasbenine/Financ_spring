package com.example.projetospring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

   @Id
   private String login;

   private String nomeCompleto;

   private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
