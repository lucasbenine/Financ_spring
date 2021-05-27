package com.example.projetospring.controller;

import com.example.projetospring.service.ContasAPagarService;
import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/contasapagar")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService service;

    @Autowired
    private ContasAPagarRepository repository;

    @GetMapping
    public List<ContasAPagar> listaContas(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<ContasAPagar> contasapagar (@RequestBody ContasAPagar contasapagar){

        contasapagar = service.inserir(contasapagar);

        return ResponseEntity.ok().body(contasapagar);
    }

}
