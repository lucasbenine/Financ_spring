package com.example.projetospring.config;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.model.Despesa;
import com.example.projetospring.repository.CategoriaRepository;
import com.example.projetospring.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria(null, "Estudo");
        Categoria c2 = new Categoria(null, "Bares e restaurantes");
        Categoria c3 = new Categoria(null, "Estudo12");
        Categoria c4 = new Categoria(null, "Bares e restaurantes12");

        Despesa d1 = new Despesa(null, "Faculdade", 680.0, Instant.parse("2021-05-10T19:53:07Z"), "Parcela da faculdade", c1);
        Despesa d2 = new Despesa(null, "cerveja", 30.0, Instant.parse("2021-05-11T19:53:07Z"), "Cerveja no bar", c2);
        Despesa d3 = new Despesa(null, "pizza", 35.0, Instant.parse("2021-10-12T19:53:07Z"), "pizza", c2);
        Despesa d4 = new Despesa(null, "Faculdade1", 680.0, Instant.parse("2021-05-12T19:53:07Z"), "Parcela da faculdade", c1);
        Despesa d5 = new Despesa(null, "cerveja1", 30.0, Instant.parse("2020-05-12T19:53:07Z"), "Cerveja no bar", c3);
        Despesa d6 = new Despesa(null, "pizza1", 35.0, Instant.parse("2019-05-12T19:53:07Z"), "pizza", c4);
        Despesa d7 = new Despesa(null, "Faculdade2", 680.0, Instant.parse("2021-08-11T19:53:07Z"), "Parcela da faculdade", c1);
        Despesa d8 = new Despesa(null, "cerveja2", 30.0, Instant.parse("2020-06-10T19:53:07Z"), "Cerveja no bar", c2);
        Despesa d9 = new Despesa(null, "pizza2", 35.0, Instant.parse("2021-05-12T19:53:07Z"), "pizza", c4);

        categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        despesaRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
    }
}
