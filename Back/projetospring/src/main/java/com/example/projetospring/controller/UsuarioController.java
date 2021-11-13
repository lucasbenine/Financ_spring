package com.example.projetospring.controller;

import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.UsuarioRepository;
import com.example.projetospring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService uServ;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final PasswordEncoder encoder;

    public UsuarioController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping
    public List<Usuario> listaUsuarios (){
        return uServ.findUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody Usuario usuario){
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuario = uServ.cadastrarUsuario(usuario);
        return ResponseEntity.ok().body(uServ.cadastrarUsuario(usuario));
    }

    @GetMapping("/validarsenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String username, @RequestParam String password) {

        Optional<Usuario> optUsuario = usuarioRepository.findByUsername(username);

        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = false;

        valid = encoder.matches(password, optUsuario.get().getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

    @GetMapping(value = "/{usuarioId}")
    public ResponseEntity<Usuario> findUsuarioById (@PathVariable Long usuarioId){
        Usuario obj = uServ.findUsuarioID(usuarioId);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{usuarioId}")
    public ResponseEntity<Usuario> alterarUsuario (@RequestBody Usuario usuarios, @PathVariable Long usuarioId){
        usuarios = uServ.alterarUsuario(usuarioId, usuarios);
        return ResponseEntity.ok().body(usuarios);
    }


    @DeleteMapping(value = "/{usuarioId}")
    public ResponseEntity<Void> deleteUsaurio(@PathVariable Long usuarioId){
        uServ.deletarUsuario(usuarioId);
        return ResponseEntity.noContent().build();
    }


}
