package com.financ.teste.config;


import com.financ.teste.entities.Categoria;
import com.financ.teste.entities.Despesa;
import com.financ.teste.entities.User;
import com.financ.teste.repositories.CategoriaRepository;
import com.financ.teste.repositories.DespesaRepository;
import com.financ.teste.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria(null, "Estudo");
        Categoria c2 = new Categoria(null, "Bares e restaurantes");

        Despesa d1 = new Despesa(null, "Faculdade", 680.0, Instant.parse("2021-05-12T19:53:07Z"), "Parcela da faculdade", c1);
        Despesa d2 = new Despesa(null, "cerveja", 30.0, Instant.parse("2021-05-12T19:53:07Z"), "Cerveja no bar", c2);
        Despesa d3 = new Despesa(null, "pizza", 35.0, Instant.parse("2021-05-12T19:53:07Z"), "pizza", c2);

        User u1 = new User(null, "toyo", "$2a$10$LBVRYRqwlcmp8ERLb09NfOdyUtn21lecg7FrMOnStrWIuxzU/gbVy", "Shimazu Toyohisa", true);
        User u2 = new User(null, "oda", "$2a$10$LBVRYRqwlcmp8ERLb09NfOdyUtn21lecg7FrMOnStrWIuxzU/gbVy", "Oda Nobunaga", false);

        categoriaRepository.saveAll(Arrays.asList(c1, c2));
        despesaRepository.saveAll(Arrays.asList(d1, d2, d3));
        userRepository.saveAll(Arrays.asList(u1, u2));
    }


}
