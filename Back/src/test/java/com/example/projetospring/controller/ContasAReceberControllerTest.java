/*
package com.example.projetospring.controller;

import com.example.projetospring.model.ContasAReceber;
import com.example.projetospring.service.ContasAReceberService;
import com.example.projetospring.util.ContasAPagarCreator;
import com.example.projetospring.util.ContasAReceberCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
class ContasAReceberControllerTest {

    @InjectMocks
    private ContasAReceberController contasAReceberController;

    @Mock
    private ContasAReceberService contasAReceberServiceMock;

    @BeforeEach
    public void setup() {
        List<ContasAReceber> listContas = new ArrayList<>();
        listContas.add(ContasAReceberCreator.createValidContasAReceber());
        BDDMockito.when(contasAReceberServiceMock.findAll())
                .thenReturn(listContas);
        BDDMockito.when(contasAReceberServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(ContasAReceberCreator.createValidContasAReceber());
        BDDMockito.when(contasAReceberServiceMock.inserir(ArgumentMatchers.any()))
                .thenReturn(ContasAReceberCreator.createValidContasAReceber());
        BDDMockito.doNothing().when(contasAReceberServiceMock).deletarConta(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("Listagem de contas deve retornar sucesso")
    void listaContasComSucesso() {
        String expectedName = ContasAReceberCreator.createValidContasAReceber().getNomeConta();
        List<ContasAReceber> listContas = contasAReceberController.listaContas();
        Assertions.assertThat(listContas).isNotNull();
        Assertions.assertThat(listContas.get(0).getNomeConta()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Procura uma conta pelo ID e retorna sucesso")
    void BuscaUmaContaPeloID() {
        Long expectedID = ContasAPagarCreator.createValidContasAPagar().getId();
        ContasAReceber contasAReceber = contasAReceberController.findById(1L).getBody();
        Assertions.assertThat(contasAReceber).isNotNull();
        Assertions.assertThat(contasAReceber.getId()).isNotNull().isEqualTo(expectedID);
    }

    @Test
    @DisplayName("Cadastra uma conta e retorna sucesso")
    void CadastraContaEDeveRetornarSucesso() {
        ContasAReceber contasAReceber = contasAReceberController.cadastraConta(ContasAReceberCreator.creataContasAReceberToBeSaved()).getBody();
        Assertions.assertThat(contasAReceber.getNomeConta()).isNotNull().isEqualTo(ContasAReceberCreator.creataContasAReceberToBeSaved().getNomeConta());
    }

    @Test
    @DisplayName("Deleta uma conta se obtiver sucesso")
    void deletaContaSeRetornarSucesso() {
        Assertions.assertThatCode(() -> contasAReceberController.deletarConta(1L))
                .doesNotThrowAnyException();
        ResponseEntity<Void> entity = contasAReceberController.deletarConta(1L);
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
*/