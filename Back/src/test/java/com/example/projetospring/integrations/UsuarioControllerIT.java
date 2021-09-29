package com.example.projetospring.integrations;

import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;
import com.example.projetospring.util.UsuarioCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class UsuarioControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Listagem de usuários deve retornar sucesso")
    void list_ReturnListOfUsuarios_WhenSuccesful() {
        Usuario usuarioSaved = usuarioRepository.save(UsuarioCreator.creataUsuarioToBeSaved());

        String expectedName = usuarioSaved.getNome();

        List<Usuario> usuarioList = testRestTemplate.exchange("/usuario", HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Usuario>>(){

            }).getBody();

        Assertions.assertThat(usuarioList).isNotNull().isNotEmpty().hasSize(1);


        Assertions.assertThat(usuarioList.get(0).getNome()).isEqualTo(expectedName);
    }
}
