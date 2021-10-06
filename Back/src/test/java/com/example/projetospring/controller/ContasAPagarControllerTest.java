package com.example.projetospring.controller;

import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.service.ContasAPagarService;
import com.example.projetospring.util.ContasAPagarCreator;
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
class ContasAPagarControllerTest {

    @InjectMocks
    private ContasAPagarController contasAPagarController;

    @Mock
    private ContasAPagarService contasAPagarServiceMock;

        @BeforeEach
        public void setup() {
            List<ContasAPagar> listContas = new ArrayList<>();
            listContas.add(ContasAPagarCreator.createValidContasAPagar());

            BDDMockito.when(contasAPagarServiceMock.findAll())
                    .thenReturn(listContas);
            BDDMockito.when(contasAPagarServiceMock.findById(ArgumentMatchers.anyLong()))
                    .thenReturn(ContasAPagarCreator.createValidContasAPagar());
            BDDMockito.when(contasAPagarServiceMock.inserir(ArgumentMatchers.any()))
                    .thenReturn(ContasAPagarCreator.createValidContasAPagar());
            BDDMockito.doNothing().when(contasAPagarServiceMock).deletarConta(ArgumentMatchers.anyLong());
        }

        @Test
        @DisplayName("Listagem de contas deve retornar sucesso")
        void listaContasComSucesso() {
            String expectedName = ContasAPagarCreator.createValidContasAPagar().getNomeConta();
            List<ContasAPagar> listContas = contasAPagarServiceMock.findAll();

            Assertions.assertThat(listContas).isNotNull();
            Assertions.assertThat(listContas.get(0).getNomeConta()).isEqualTo(expectedName);
        }

        @Test
        @DisplayName("Procura uma conta pelo ID e retorna sucesso")
        void BuscaUmaContaPeloID() {
            Long expectedID = ContasAPagarCreator.createValidContasAPagar().getId();
            ContasAPagar contasAPagar = contasAPagarController.findById(1L).getBody();
            Assertions.assertThat(contasAPagar).isNotNull();
            Assertions.assertThat(contasAPagar.getId()).isNotNull().isEqualTo(expectedID);
        }

        @Test
        @DisplayName("Cadastra uma conta e retorna sucesso")
        void CadastraContaEDeveRetornarSucesso() {
            ContasAPagar contasAPagar = contasAPagarController.inserirConta(ContasAPagarCreator.creataContasAPagarToBeSaved()).getBody();
            Assertions.assertThat(contasAPagar.getNomeConta()).isNotNull().isEqualTo(ContasAPagarCreator.creataContasAPagarToBeSaved().getNomeConta());
        }

        @Test
        @DisplayName("Deleta uma conta se obtiver sucesso")
        void deletaContaSeRetornarSucesso() {
            Assertions.assertThatCode(() -> contasAPagarController.deletarConta(1L))
                    .doesNotThrowAnyException();
            ResponseEntity<Void> entity = contasAPagarController.deletarConta(1L);
            Assertions.assertThat(entity).isNotNull();
            Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        }
}
