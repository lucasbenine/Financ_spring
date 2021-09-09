package com.example.projetospring.repository;

import com.example.projetospring.model.Receitas;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Testes receitas repository")
public class ReceitasRepositoryTest {

    @Autowired
    private ReceitaRepository rep;

    private Receitas createReceita(){
        Receitas receita = new Receitas();
        receita.setNome("Salário");
        receita.setValor(2200.00);
        receita.setDescricao("Salário do mês");
        return receita;
    }

    @Test
    @DisplayName("teste de cadastro de receita")
    void addReceita() {
        Receitas receita = createReceita();
        Receitas savedReceita = this.rep.save(receita);

        Assertions.assertThat(savedReceita).isNotNull();
        Assertions.assertThat(savedReceita.getId()).isNotNull();
        Assertions.assertThat(savedReceita.getNome()).isEqualTo(receita.getNome());
    }

    @Test
    @DisplayName("teste para atualizar uma receita")
    void updateReceita() {
        Receitas receita = createReceita();
        Receitas savedReceita = this.rep.save(receita);
        savedReceita.setNome("Salario");
        Receitas attReceita = this.rep.save(savedReceita);

        Assertions.assertThat(attReceita).isNotNull();
        Assertions.assertThat(attReceita.getId()).isNotNull();
        Assertions.assertThat(attReceita.getNome()).isEqualTo(savedReceita.getNome());
    }
}
