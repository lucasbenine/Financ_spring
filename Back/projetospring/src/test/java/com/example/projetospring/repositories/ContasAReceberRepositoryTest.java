package com.example.projetospring.repositories;

import com.example.projetospring.model.ContasAReceber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Teste para a interface ContasAReceber Repository")
class ContasAReceberRepositoryTest {

    @Autowired
    private ContasAReceberRepository repository;

    @Test
    @DisplayName("Teste para salvar uma conta a receber")
    void saveConta(){
        ContasAReceber contaAReceberSalvar = createConta();

        ContasAReceber contaSalva = this.repository.save(contaAReceberSalvar);

        Assertions.assertThat(contaSalva).isNotNull();

        Assertions.assertThat(contaSalva.getId()).isNotNull();

        Assertions.assertThat(contaSalva.getNomeConta()).isEqualTo(contaAReceberSalvar.getNomeConta());
    }

    @Test
    @DisplayName("Teste para atualizar uma conta a receber")
    void updateConta(){
        ContasAReceber contaAReceberSalvar = createConta();

        ContasAReceber contaSalva = this.repository.save(contaAReceberSalvar);

        contaSalva.setNomeConta("Venda de uva");

        ContasAReceber contaAtualizada = this.repository.save(contaSalva);

        Assertions.assertThat(contaAtualizada).isNotNull();

        Assertions.assertThat(contaAtualizada.getId()).isNotNull();

        Assertions.assertThat(contaAtualizada.getNomeConta()).isEqualTo(contaSalva.getNomeConta());
    }

    private ContasAReceber createConta(){
        ContasAReceber contasreceber = new ContasAReceber();
        contasreceber.setNomeConta("Teste - nome conta");
        contasreceber.setValorConta(200.15);
        contasreceber.setCategoria("Teste - categoria");
        return contasreceber;
    }

}
