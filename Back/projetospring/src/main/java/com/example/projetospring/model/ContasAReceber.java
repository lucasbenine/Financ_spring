package com.example.projetospring.model;

import javax.persistence.*;

@Entity
public class ContasAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeConta;
    private Double valorConta;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public ContasAReceber(){
    }

    public ContasAReceber(String nomeConta, Double valorConta, String categoria) {
        this.nomeConta = nomeConta;
        this.valorConta = valorConta;
        this.categoria = categoria;
    }

    public ContasAReceber(String nomeConta, Double valorConta, String categoria, Usuario usuario) {
        this.nomeConta = nomeConta;
        this.valorConta = valorConta;
        this.categoria = categoria;
        this.usuario = usuario;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
