package com.example.projetospring.model;

import javax.persistence.*;

@Entity
public class ContasAPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeConta;

    private Double valorConta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public ContasAPagar() {

    }

    public ContasAPagar(String nomeConta, Double valorConta, Categoria categoria) {
        this.nomeConta = nomeConta;
        this.valorConta = valorConta;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
