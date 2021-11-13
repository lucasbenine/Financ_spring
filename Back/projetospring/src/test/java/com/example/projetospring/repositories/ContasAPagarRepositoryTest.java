package com.example.projetospring.repositories;


import com.example.projetospring.model.ContasAPagar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Teste para a interface ContasAPagar Repository")
public class ContasAPagarRepositoryTest {

    @Autowired
    private ContasAPagarRepository repository;

    @Test
    @DisplayName("Primeiro teste da classe Contas A Pagar")
    void saveConta(){
        ContasAPagar contaParaSalvar = createConta();
        ContasAPagar contaSalva = this.repository.save(contaParaSalvar);
        Assertions.assertThat(contaSalva).isNotNull();
        Assertions.assertThat(contaSalva.getId()).isNotNull();
        Assertions.assertThat(contaSalva.getNomeConta()).isEqualTo(contaParaSalvar.getNomeConta());
    }

    private ContasAPagar createConta(){
        ContasAPagar contasapagar = new ContasAPagar();
        contasapagar.setNomeConta("Teste - nome conta");
        contasapagar.setValorConta(200.15);
        contasapagar.setCategoria("Teste - categoria");
        return contasapagar;
    }
}
