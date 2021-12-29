package com.example.projetospring.model;

import java.io.Serializable;

public class Balanco implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double somaReceitas;
    private Double somaDespesas;

    public Balanco() {

    }

    public Balanco(Double somaReceitas, Double somaDespesas) {
        this.somaReceitas = somaReceitas;
        this.somaDespesas = somaDespesas;
    }

    public Double getSomaReceitas() {
        return somaReceitas;
    }

    public void setSomaReceitas(Double somaReceitas) {
        this.somaReceitas = somaReceitas;
    }

    public Double getSomaDespesas() {
        return somaDespesas;
    }

    public void setSomaDespesas(Double somaDespesas) {
        this.somaDespesas = somaDespesas;
    }
}
