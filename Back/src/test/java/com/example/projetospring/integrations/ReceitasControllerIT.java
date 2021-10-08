package com.example.projetospring.integrations;

import com.example.projetospring.model.Receitas;
import com.example.projetospring.repository.ReceitaRepository;
import com.example.projetospring.util.ReceitaCreator;
import com.example.projetospring.util.UsuarioCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReceitasControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    ReceitaRepository rRep;

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder(){
            return new RestTemplateBuilder().basicAuthentication("lucas", "1234");
        }
    }

    Receitas receitas = new Receitas(15L, "teste", 12.50, "teste", UsuarioCreator.createValidUsuario());

    @Test
    public void ReturnReceita_WhenSuccesfull(){
        testRestTemplate = testRestTemplate.withBasicAuth("lucas", "1234");
        ResponseEntity<Receitas> response = this.testRestTemplate
                .postForEntity("Http://localhost:" + port + "/receitas", ReceitaCreator.createValidReceita(), Receitas.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getNome()).isEqualTo(ReceitaCreator.createValidReceita().getNome());


    }
}
