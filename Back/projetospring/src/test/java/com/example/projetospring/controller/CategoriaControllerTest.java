package com.example.projetospring.controller;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.services.CategoriaService;
import com.example.projetospring.util.CategoriaCreator;
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
public class CategoriaControllerTest {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaServiceMock;

    @BeforeEach
    public void setup() {
        List<Categoria> categoriaList = new ArrayList<Categoria>();
        categoriaList.add(CategoriaCreator.createValidCategoria());

        BDDMockito.when(categoriaServiceMock.findAll())
                .thenReturn(categoriaList);
        BDDMockito.when(categoriaServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(CategoriaCreator.createValidCategoria());

        BDDMockito.when(categoriaServiceMock.insert(ArgumentMatchers.any()))
                .thenReturn(CategoriaCreator.createValidCategoria());

        BDDMockito.doNothing().when(categoriaServiceMock).delete(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("List returns list of Categorias when succesful")
    void list_ReturnsListOfCategoria_WhenSuccesful() {
        String expectedName = CategoriaCreator.createValidCategoria().getNomeCategoria();
        List<Categoria> categoriaList = categoriaController.findAll().getBody();

        Assertions.assertThat(categoriaList).isNotNull();
        Assertions.assertThat(categoriaList.get(0).getNomeCategoria()).isEqualTo(expectedName);

    }

    @Test
    @DisplayName("Find by id returns Categoria when succesful")
    void findById_ReturnsCategoria_WhenSuccesful() {
        Long expectedId = CategoriaCreator.createValidCategoria().getId();

        Categoria categoria = categoriaController.findById(1L).getBody();

        Assertions.assertThat(categoria).isNotNull();
        Assertions.assertThat(categoria.getId()).isNotNull().isEqualTo(expectedId);

    }

    @Test
    @DisplayName("save returns Categoria when succesful")
    void save_ReturnsCategoria_WhenSuccesful() {

        Categoria categoria = categoriaController.insert(CategoriaCreator.createCategoriaToBeSaved()).getBody();

        Assertions.assertThat(categoria.getNomeCategoria()).isNotNull().isEqualTo(CategoriaCreator.createValidCategoria().getNomeCategoria());
        Assertions.assertThat(categoria.getId()).isNotNull().isEqualTo(CategoriaCreator.createValidCategoria().getId());
    }

    @Test
    @DisplayName("delete removes Categoria when succesful")
    void delete_RemovesCategoria_WhenSuccesful() {

        Assertions.assertThatCode(() -> categoriaController.delete(1L))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = categoriaController.delete(1L);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

    }
}
