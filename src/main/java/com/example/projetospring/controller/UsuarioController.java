package com.example.projetospring.controller;


import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;
import com.example.projetospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService uServ;

    @GetMapping
    public List<Usuario> listaUsuarios (){
        return uServ.findUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody Usuario usuarios){
        usuarios = uServ.cadastrarUsuario(usuarios);
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<Usuario> findUsuarioById (@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println(userDetails);
        Usuario obj = uServ.findUsuarioID(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> alterarUsuario (@RequestBody Usuario usuarios, @PathVariable Long id){
        usuarios = uServ.alterarUsuario(id, usuarios);
        return ResponseEntity.ok().body(usuarios);
    }


    @DeleteMapping(value = "/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUsaurio(@PathVariable Long id){
        uServ.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
