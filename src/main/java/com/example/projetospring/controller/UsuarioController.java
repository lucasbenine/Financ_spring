package com.example.projetospring.controller;


import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;
import com.example.projetospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService uServ;

    @Autowired
    private UsuarioRepository uRep;

    @GetMapping
    public List<Usuario> listaUsuarios (){
        return uServ.findUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody Usuario usuarios){
        usuarios = uServ.cadastrarUsuario(usuarios);
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity<Usuario> findUsuarioById (@PathVariable Long id, @RequestBody Usuario usuarios){
        usuarios = uServ.alterarUsuario(id, usuarios);
        return ResponseEntity.ok().body(usuarios);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<Void> deleteUsaurio(@PathVariable Long id){
        uServ.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
