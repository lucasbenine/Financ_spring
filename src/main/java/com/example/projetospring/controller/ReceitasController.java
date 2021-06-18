package com.example.projetospring.controller;

import com.example.projetospring.model.Receitas;
import com.example.projetospring.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receitas")
public class ReceitasController {

    @Autowired
    private ReceitaService rServ;

    @GetMapping
    public ResponseEntity<List<Receitas>> listaReceitas (){
        List<Receitas> list = rServ.listReceitas();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Receitas> cadastrarDespesa(@RequestBody Receitas receitas){
        receitas = rServ.cadastroReceita(receitas);
        return ResponseEntity.ok().body(receitas);
    }

    @GetMapping(value = "/{Id}" )
    public ResponseEntity<Receitas> findReceitaById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println(userDetails);
        Receitas obj = rServ.findReceitaById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity<Receitas> alterarReceita(@RequestBody Receitas receitas, @PathVariable Long id){
       receitas = rServ.alterarReceita(id, receitas);
       return ResponseEntity.ok().body(receitas);
    }

    @DeleteMapping(value = "/{Id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteReceita(@PathVariable Long id){
        rServ.deleteReceita(id);
        return ResponseEntity.noContent().build();

    }
}
