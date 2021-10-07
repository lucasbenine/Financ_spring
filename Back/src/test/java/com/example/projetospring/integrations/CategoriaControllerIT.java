package com.example.projetospring.integrations;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.repository.CategoriaRepository;
import com.example.projetospring.util.CategoriaCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriaControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CategoriaRepository categoriaRepository;

    Categoria categoria = new Categoria(1L, "testedoteste");

    @Test
    public void save_ReturnsCategoria_WhenSuccesful() {
        ResponseEntity<Categoria> responseEntity = this.restTemplate
                .postForEntity("http://localhost:"+ port +"/categorias", CategoriaCreator.createValidCategoria(), Categoria.class);

//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody().getNomeCategoria()).isEqualTo(CategoriaCreator.createValidCategoria().getNomeCategoria());
    }

    @Test
    public void list_ReturnsListOfCategoria_WhenSuccesful() {
        Categoria categoriaSaved = categoriaRepository.save(CategoriaCreator.createValidCategoria());
        String expectedName = categoriaSaved.getNomeCategoria();

        List<Categoria> categorias = restTemplate.exchange("/categorias", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Categoria>>() {
                }).getBody();

        Assertions.assertThat(categorias).isNotNull();
        Assertions.assertThat(categorias.get(0).getNomeCategoria()).isEqualTo(expectedName);
    }

    @Test
    public void findById_ReturnsCategoria_WhenSuccesful() {
        categoriaRepository.save(CategoriaCreator.createValidCategoria());
        ResponseEntity<Categoria> responseEntity = this.restTemplate
                .getForEntity("http://localhost:"+ port+"/categorias/1", Categoria.class);

//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(CategoriaCreator.createValidCategoria().getId());
        Assertions.assertThat(responseEntity.getBody().getNomeCategoria()).isEqualTo(CategoriaCreator.createValidCategoria().getNomeCategoria());

    }
}
