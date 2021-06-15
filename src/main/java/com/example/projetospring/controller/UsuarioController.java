package com.example.projetospring.controller;

import com.example.projetospring.model.Usuario;
import com.example.projetospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listUsuario());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.listByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario){
        return new ResponseEntity<>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> attUsuario(@RequestBody Usuario usuario){
        usuarioService.replaceUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
