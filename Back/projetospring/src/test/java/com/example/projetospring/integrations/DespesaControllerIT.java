//package com.example.projetospring.integrations;
//
//import com.example.projetospring.model.Despesa;
//import com.example.projetospring.repositories.CategoriaRepository;
//import com.example.projetospring.repositories.DespesaRepository;
//import com.example.projetospring.util.CategoriaCreator;
//import com.example.projetospring.util.DespesaCreator;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class DespesaControllerIT {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    DespesaRepository despesaRepository;
//
//    @Autowired
//    CategoriaRepository categoriaRepository;
//
//
//    @Test
//    public void testAddCategoria() {
//        categoriaRepository.save(CategoriaCreator.createValidCategoria());
//        ResponseEntity<Despesa> responseEntity = this.restTemplate
//                .postForEntity("http://localhost:" + port + "/despesas", DespesaCreator.createValidDespesa(), Despesa.class);
//
////        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//    @Test
//    public void testAdddCategoria() {
//        categoriaRepository.save(CategoriaCreator.createValidCategoria());
//        ResponseEntity<Despesa> responseEntity = this.restTemplate
//                .postForEntity("http://localhost:" + port + "/despesas", DespesaCreator.createInvalidDespesa(), Despesa.class);
//
////        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//    }
//
//
//
//    @Test
//    public void testGetCategoria() {
//        categoriaRepository.save(CategoriaCreator.createValidCategoria());
//        Despesa despesa = despesaRepository.save(DespesaCreator.createDespesaToBeSaved());
//        ResponseEntity<Despesa> responseEntity = this.restTemplate
//                .getForEntity("http://localhost:" + port + "/despesas/1", Despesa.class);
//
////        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseEntity.getBody().getNome()).isEqualTo(despesa.getNome());
//        Assertions.assertThat(responseEntity.getBody().getPreco()).isEqualTo(despesa.getPreco());
//        Assertions.assertThat(responseEntity.getBody().getDescricao()).isEqualTo(despesa.getDescricao());
//
//
//    }
//
//}
//
