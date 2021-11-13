package com.example.projetospring.repositories;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.util.CategoriaCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("Testes da Categoria Repository")
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    void save_PersistCategoria_WhenSuccesful() {
        Categoria categoria = new Categoria(null, "Teste de Categoria");
        this.categoriaRepository.save(categoria);
        Assertions.assertThat(categoria.getId()).isNotNull();
        Assertions.assertThat(categoria.getNomeCategoria()).isEqualTo("Teste de Categoria");
    }

    @Test
    void list_ListCategorias_WhenSuccesful() {
        categoriaRepository.saveAll(Arrays.asList(CategoriaCreator.createCategoriaToBeSaved(), CategoriaCreator.createValidCategoria()));
        List<Categoria> categorias = categoriaRepository.findAll();

        Assertions.assertThat(categorias).isNotNull();
    }

    @Test
    void save_UpdatesCategoria_WhenSuccesful() {
        Categoria categoria = new Categoria(null, "Teste de Categoria");
        Categoria categoriaSaved = this.categoriaRepository.save(categoria);

        categoriaSaved.setNomeCategoria("Educação");
        Categoria categoriaUpdated = this.categoriaRepository.save(categoriaSaved);

        Assertions.assertThat(categoriaUpdated.getId()).isNotNull();
        Assertions.assertThat(categoriaUpdated.getNomeCategoria()).isEqualTo(categoriaSaved.getNomeCategoria());
    }

    @Test
    void delete_RemovesCategoria_WhenSuccesful() {
        Categoria categoria = new Categoria(null, "Teste de Categoria");
        Categoria categoriaSaved = this.categoriaRepository.save(categoria);

        this.categoriaRepository.delete(categoriaSaved);
        Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(categoriaSaved.getId());

        Assertions.assertThat(categoriaOptional).isEmpty();
    }

    private Categoria createCategoria() {
        Categoria categoria = new Categoria(null, "Teste diferente");
        return categoria;
    }
}
