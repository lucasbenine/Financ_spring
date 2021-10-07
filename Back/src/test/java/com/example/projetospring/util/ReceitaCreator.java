package com.example.projetospring.util;

import com.example.projetospring.model.Receitas;

public class ReceitaCreator {

    public static Receitas createReceitaToBeSaved() {
        Receitas receita = new Receitas(null, "Salário", 2400.00, "salário do meês", UsuarioCreator.createValidUsuario());
        return receita;
    }

    public static Receitas createValidReceita() {
        Receitas receita = new Receitas(15L, "Freelance", 250.00, "Freela no wordpress", UsuarioCreator.createValidUsuario());
        return receita;
    }

    public static Receitas createValidUpdatedReceita() {
        Receitas receita = new Receitas(1L, "Salário2", 2500.00, "salário do mês", UsuarioCreator.createValidUsuario());
        return receita;
    }

}
