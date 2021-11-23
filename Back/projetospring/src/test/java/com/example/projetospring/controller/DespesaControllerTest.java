package com.example.projetospring.controller;

import com.example.projetospring.model.Despesa;
import com.example.projetospring.services.DespesaService;
import com.example.projetospring.util.DespesaCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class DespesaControllerTest {

    @InjectMocks
    private DespesaController despesaController;

    @Mock
    private DespesaService despesaServiceMock;

    @BeforeEach
    void setup() {
        PageImpl<Despesa> despesaPage = new PageImpl<>(List.of(DespesaCreator.createValidDespesa()));
        BDDMockito.when(despesaServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(despesaPage);

        BDDMockito.when(despesaServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(DespesaCreator.createValidDespesa());

        BDDMockito.when(despesaServiceMock.insert(ArgumentMatchers.any()))
                .thenReturn(DespesaCreator.createValidDespesa());

        BDDMockito.doNothing().when(despesaServiceMock).delete(ArgumentMatchers.anyLong());
    }

    @Test
    void list_ReturnsListOfDespesasInsidePageObject_WhenSuccesful() {
        String expectedName = DespesaCreator.createValidDespesa().getNome();
        Page<Despesa> despesaPage = despesaController.findAll(null).getBody();

        Assertions.assertThat(despesaPage).isNotNull();
        Assertions.assertThat(despesaPage.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(despesaPage.toList().get(0).getNome()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Find by id returns Despesa when succesful")
    void findById_ReturnsDespesa_WhenSuccesful() {
        Long expectedId = DespesaCreator.createValidDespesa().getId();

        Despesa despesa = despesaController.findById(1L).getBody();

        Assertions.assertThat(despesa).isNotNull();
        Assertions.assertThat(despesa.getId()).isNotNull().isEqualTo(expectedId);

    }

//    @Test
//    @DisplayName("save returns Despesa when succesful")
//    void save_ReturnsDespesa_WhenSuccesful() {
//
//        Despesa despesa = despesaController.insert(DespesaCreator.createDespesaToBeSaved()).getBody();
//
//        Assertions.assertThat(despesa.getNome()).isNotNull().isEqualTo(DespesaCreator.createValidDespesa().getNome());
//        Assertions.assertThat(despesa.getPreco()).isNotNull().isEqualTo(DespesaCreator.createValidDespesa().getPreco());
//        Assertions.assertThat(despesa.getDescricao()).isNotNull().isEqualTo(DespesaCreator.createValidDespesa().getDescricao());
//    }

    @Test
    @DisplayName("delete removes Despesa when succesful")
    void delete_RemovesDespesa_WhenSuccesful() {

        Assertions.assertThatCode(() -> despesaController.delete(1L))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = despesaController.delete(1L);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

    }
}
