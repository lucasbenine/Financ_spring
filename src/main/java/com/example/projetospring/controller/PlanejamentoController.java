package com.example.projetospring.controller;


import com.example.projetospring.model.Planejamento;
import com.example.projetospring.repository.PlanejamentoRepository;
import com.example.projetospring.service.PlanejamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/planejamento")
public class PlanejamentoController {

    @Autowired
    private PlanejamentoService service;

    @Autowired
    private PlanejamentoRepository repository;

    @GetMapping
    public List<Planejamento> listaPlanejamentos(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Planejamento> planejamento (@RequestBody Planejamento planejamento){
        planejamento = service.inserirPlanejamento(planejamento);
        return ResponseEntity.ok().body(planejamento);
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity<Planejamento> planejamento (@PathVariable Long Id, @RequestBody Planejamento planejamento){
        planejamento = service.editarPlanejamento(Id,planejamento);
        return ResponseEntity.ok().body(planejamento);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<Void> deletarPlanejamento(@PathVariable Long Id) {
        service.deletarPlanejamento(Id);
        return ResponseEntity.noContent().build();
    }
}

