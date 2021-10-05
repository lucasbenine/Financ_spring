package com.example.projetospring.integrations;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.repository.CategoriaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public void testAddCategoria() {
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/categorias", categoria, String.class);

//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void testGetCategoria() {
        categoriaRepository.save(categoria);
        ResponseEntity<Categoria> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/categorias/1", Categoria.class);

//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(categoria.getId());
        Assertions.assertThat(responseEntity.getBody().getNomeCategoria()).isEqualTo(categoria.getNomeCategoria());

    }
}
