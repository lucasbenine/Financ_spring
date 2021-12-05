package com.example.projetospring.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Receitas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Date data;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaReceita categoria;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario2;

    public Receitas() {
    }

    public Receitas(Long id, String nome, Double preco, Date data, String descricao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.data = data;
        this.descricao = descricao;
        this.usuario2 = usuario;
    }

    public Receitas(Long id, String nome, Double preco, Date data, String descricao, CategoriaReceita categoria, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaReceita getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaReceita categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() { return usuario2; }

    public void setUsuario(Usuario usuario) { this.usuario2 = usuario; }
}
