package com.example.projetospring.util;

import com.example.projetospring.model.Receitas;

public class ReceitaCreator {

    public static Receitas createReceitaToBeSaved() {
        Receitas receitas = new Receitas(null, "Buteco", 12.50, "Litrão depois da aula", UsuarioCreator.createValidUsuario());
        return receitas;
    }

    public static Receitas createValidReceita() {
        Receitas receitas = new Receitas(32L, "Buteco", 12.50, "Litrão depois da aula", UsuarioCreator.createValidUsuario());
        return receitas;
    }
}