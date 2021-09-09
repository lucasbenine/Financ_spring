package com.example.projetospring.util;

import com.example.projetospring.model.Despesa;

public class DespesaCreator {

    public static Despesa createDespesaToBeSaved() {
        Despesa despesa = new Despesa(null, "Camiseta", 55.0, "Camiseta polo", CategoriaCreator.createValidCategoria());
        return despesa;
    }

    public static Despesa createValidDespesa() {
        Despesa despesa = new Despesa(15L, "Camiseta", 55.0, "Camiseta polo", CategoriaCreator.createValidCategoria());
        return despesa;
    }
}
