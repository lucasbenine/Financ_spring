//
//package com.example.projetospring.controller;
//
//import com.example.projetospring.model.Receitas;
//import com.example.projetospring.service.ReceitaService;
//import com.example.projetospring.util.ReceitaCreator;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//class ReceitasControllerTest {
//
//    @InjectMocks
//    private ReceitasController receitasController;
//
//    @Mock
//    private ReceitaService receitaServiceMock;
//
//    @BeforeEach
//    void setup(){
//        List<Receitas> receitasList = new ArrayList<>();
//        receitasList.add(ReceitaCreator.createValidReceita());
//
//        BDDMockito.when(receitaServiceMock.listReceitas())
//                .thenReturn(receitasList);
//
//        BDDMockito.when(receitaServiceMock.findReceitaById(ArgumentMatchers.anyLong()))
//                .thenReturn(ReceitaCreator.createValidReceita());
//
//        BDDMockito.when(receitaServiceMock.cadastroReceita(ArgumentMatchers.any()))
//                .thenReturn(ReceitaCreator.createValidReceita());
//
//        BDDMockito.doNothing().when(receitaServiceMock).deleteReceita(ArgumentMatchers.any());
//
//    }
//
//    @Test
//    @DisplayName("Lista de receitas - sucesso")
//    void list_ReturnListOfReceitas_WhenSucceful(){
//        String expectedName = ReceitaCreator.createValidReceita().getNome();
//        List<Receitas> receitasList = receitasController.listaReceitas();
//
//        Assertions.assertThat(receitasList).isNotNull();
//        Assertions.assertThat(receitasList.get(0).getNome()).isEqualTo(expectedName);
//    }
//
//
//
//    @Test
//    @DisplayName("Busca de receita por ID - sucesso")
//    void findById_ReturnReceita_WhenSuccesfull(){
//        Long expectedId = ReceitaCreator.createValidReceita().getId();
//
//        Receitas receitas = receitasController.findReceitaById(32L).getBody();
//
//        Assertions.assertThat(receitas).isNotNull();
//        Assertions.assertThat(receitas.getId()).isNotNull().isEqualTo(expectedId);
//    }
//
//
//
//    @Test
//    @DisplayName("cadastro de usuario - sucesso")
//    void savedReceita_RetunReceita_WhenSuccesfull(){
//        Receitas receitas = receitasController.cadastrarReceita(ReceitaCreator.createReceitaToBeSaved()).getBody();
//
//        Assertions.assertThat(receitas.getNome()).isNotNull().isEqualTo(ReceitaCreator.createReceitaToBeSaved().getNome());
//
//    }
//
//
//
//    @Test
//    @DisplayName("Receita deletada - sucesso")
//    void delete_DeleteReceita_WhenSuccesfull(){
//
//        Assertions.assertThatCode(() -> receitasController.deleteReceita(32L))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> entity = receitasController.deleteReceita(32L);
//
//        Assertions.assertThat(entity).isNotNull();
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//}
