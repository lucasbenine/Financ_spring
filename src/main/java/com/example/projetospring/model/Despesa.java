package com.example.projetospring.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Despesa implements Serializable{

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date data;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Despesa() {

    }

//    public Despesa(Long id, String nome, Double preco, String data, String descricao, Categoria categoria) {
//        this.id = id;
//        this.nome = nome;
//        this.preco = preco;
//        try {
//            this.data = new SimpleDateFormat("yyyy/MM/dd").parse(data);
//        } catch(ParseException ex) {
//            throw new RuntimeException(ex);
//        }
//        this.descricao = descricao;
//        this.categoria = categoria;
//    }

    public Despesa(Long id, String nome, Double preco, String data, String descricao, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        try {
            this.data = new SimpleDateFormat("yyyy/MM/dd").parse(data);
        } catch(ParseException ex) {
            throw new RuntimeException(ex);
        }
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Despesa(Long id, String nome, Double preco, String data, String descricao, Categoria categoria, Usuario usuarioDespesa) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        try {
            this.data = new SimpleDateFormat("yyyy/MM/dd").parse(data);
        } catch(ParseException ex) {
            throw new RuntimeException(ex);
        }
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuario = usuarioDespesa;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}