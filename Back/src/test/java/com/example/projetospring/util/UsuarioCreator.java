package com.example.projetospring.util;

import com.example.projetospring.model.Usuario;

public class UsuarioCreator {

    public static Usuario creataUsuarioToBeSaved() {
        Usuario usuario = new Usuario(null, "Raul Rios", "rauldomingos@email.com");
        return usuario;
    }

    public static Usuario createValidUsuario() {
        Usuario usuario = new Usuario(1L, "Raul Rios", "rauldomingos@email.com");
        return usuario;
    }

    public static Usuario createValidUpdatedUsuario() {
        Usuario usuario = new Usuario(1L, "Raul Rios2", "rauldomingos@email.com2 ");
        return usuario;
    }
}
