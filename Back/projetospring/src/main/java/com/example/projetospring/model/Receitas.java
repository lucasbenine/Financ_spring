package com.example.projetospring.model;

import javax.persistence.*;

@Entity
public class Receitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario2;

    public Receitas() {
    }

    public Receitas(Long id, String nome, Double valor, String descricao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.usuario2 = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() { return usuario2; }

    public void setUsuario(Usuario usuario) { this.usuario2 = usuario; }
}
