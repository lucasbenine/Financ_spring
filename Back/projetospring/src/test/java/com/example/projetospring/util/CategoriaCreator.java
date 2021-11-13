package com.example.projetospring.util;

import com.example.projetospring.model.Categoria;

public class CategoriaCreator {

    public static Categoria createCategoriaToBeSaved() {
        Categoria categoria = new Categoria(null, "Roupas");
        return categoria;
    }

    public static Categoria createValidCategoria() {
        Categoria categoria = new Categoria(1L, "Roupas");
        return categoria;
    }

    public static Categoria createValidUpdatedCategoria() {
        Categoria categoria = new Categoria(1L, "Roupas 1");
        return categoria;
    }
}
