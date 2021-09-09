package com.example.projetospring.repository;

import com.example.projetospring.model.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Testes da interface Repository de Usuario")
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository rep;

    private Usuario createUsuario() {
        Usuario u = new Usuario();
        u.setEmail("example@email.com");
        u.setNome("Raul Rios");
        return u;
    }

    @Test
    @DisplayName("teste para cadastrar usuario")
    void addUser() {
        Usuario user = createUsuario();
        Usuario savedUser = this.rep.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isNotNull();
        Assertions.assertThat(savedUser.getNome()).isEqualTo(user.getNome());
    }

    @Test
    @DisplayName("teste para atualizar um usuário")
    void updateUser() {
        Usuario user = createUsuario();
        Usuario savedUser = this.rep.save(user);
        savedUser.setNome("Luisa");
        Usuario attUser = this.rep.save(savedUser);

        Assertions.assertThat(attUser).isNotNull();
        Assertions.assertThat(attUser.getId()).isNotNull();
        Assertions.assertThat(attUser.getNome()).isEqualTo(savedUser.getNome());
    }

}
