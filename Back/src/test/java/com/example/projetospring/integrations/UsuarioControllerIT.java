package com.example.projetospring.integrations;


import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;
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
public class UsuarioControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restemp;

    @Autowired
    UsuarioRepository urep;

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().basicAuthentication("lucas", "1234");
        }
    }

    Usuario usuario = new Usuario(1L, "Usuario Teste", "email@email.com");

    @Test
    public void returnUsuer_whenSucesful() {
        restemp = restemp.withBasicAuth("lucas", "1234");
        ResponseEntity<Usuario> response = this.restemp
                .postForEntity("http://localhost:" + port + "/usuarios", UsuarioCreator.createValidUsuario(), Usuario.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getNome()).isEqualTo(UsuarioCreator.createValidUsuario().getNome());
    }
}


