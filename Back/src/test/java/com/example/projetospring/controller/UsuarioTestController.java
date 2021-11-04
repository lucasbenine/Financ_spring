//package com.example.projetospring.controller;
//
//import com.example.projetospring.controller.UsuarioController;
//import com.example.projetospring.model.Usuario;
//import com.example.projetospring.service.UsuarioService;
//import com.example.projetospring.util.UsuarioCreator;
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
//class UsuarioControllerTest {
//
//    @InjectMocks
//    private UsuarioController ucontrol;
//
//    @Mock
//    private UsuarioService uservMock;
//
//    @BeforeEach
//    public void setup() {
//        List<Usuario> usuarioList = new ArrayList<>();
//        usuarioList.add(UsuarioCreator.createValidUsuario());
//
//        BDDMockito.when(uservMock.findUsuarios())
//                .thenReturn(usuarioList);
//        BDDMockito.when(uservMock.findUsuarioID(ArgumentMatchers.anyLong()))
//                .thenReturn(UsuarioCreator.createValidUsuario());
//
//        BDDMockito.when(uservMock.cadastrarUsuario(ArgumentMatchers.any()))
//                .thenReturn(UsuarioCreator.createValidUsuario());
//
//        BDDMockito.doNothing().when(uservMock).deletarUsuario(ArgumentMatchers.anyLong());
//    }
//
//    @Test
//    @DisplayName("Listagem de usuários deve retornar sucesso")
//    void list_ReturnListOfUsuarios_WhenSuccesful() {
//        String expectedName = UsuarioCreator.createValidUsuario().getNome();
//        List<Usuario> usuarioList = ucontrol.listaUsuarios();
//
//        Assertions.assertThat(usuarioList).isNotNull();
//        Assertions.assertThat(usuarioList.get(0).getNome()).isEqualTo(expectedName);
//    }
//
//    @Test
//    @DisplayName("Procura um usuario pelo id e retorna sucesso")
//    void findById_ReturnUsuario_WhenSuccesful() {
//        Long expectedID = UsuarioCreator.createValidUsuario().getId();
//
//        Usuario usuario = ucontrol.findUsuarioById(1L).getBody();
//
//        Assertions.assertThat(usuario).isNotNull();
//        Assertions.assertThat(usuario.getId()).isNotNull().isEqualTo(expectedID);
//    }
//
//    @Test
//    @DisplayName("Cadastra um usuario e retorna sucesso")
//    void saveUsuario_ReturnUsuario_WhenSuccesful() {
//
//        Usuario usuario = ucontrol.cadastroUsuario(UsuarioCreator.creataUsuarioToBeSaved()).getBody();
//        Assertions.assertThat(usuario.getNome()).isNotNull().isEqualTo(UsuarioCreator.creataUsuarioToBeSaved().getNome());
//    }
//
//    @Test
//    @DisplayName("Deleta um usuário se obtiver sucesso")
//    void delete_DeleteUsuario_WhenSuccesful() {
//        Assertions.assertThatCode(() -> ucontrol.deleteUsaurio(1L))
//                .doesNotThrowAnyException();
//
//        ResponseEntity<Void> entity = ucontrol.deleteUsaurio(1L);
//
//        Assertions.assertThat(entity).isNotNull();
//
//        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//    }
//}