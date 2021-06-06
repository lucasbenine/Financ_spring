package com.example.projetospring.controller;

import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.model.ContasAReceber;
import com.example.projetospring.repository.ContasAReceberRepository;
import com.example.projetospring.service.ContasAReceberService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


    @RestController
    @RequestMapping("/contasareceber")
    public class ContasAReceberController {

        @Autowired
        private ContasAReceberService service;

        @Autowired
        private ContasAReceberRepository repository;

        @GetMapping
        public List<ContasAReceber> listaContas(){
            return repository.findAll();
        }

        @PostMapping
        public ResponseEntity<ContasAReceber> contasareceber (@RequestBody ContasAReceber contasareceber){
            contasareceber = service.inserir(contasareceber);
            return ResponseEntity.ok().body(contasareceber);
        }

        @PutMapping(value = "/{Id}")
        public ResponseEntity<ContasAReceber> contasareceber (@PathVariable Long Id, @RequestBody ContasAReceber contasareceber){

            contasareceber = service.editarConta(Id,contasareceber);
            return ResponseEntity.ok().body(contasareceber);
        }

        @DeleteMapping(value = "/{Id}")
        public ResponseEntity<Void> deletarConta(@PathVariable Long Id) {

            service.deletarConta(Id);
            return ResponseEntity.noContent().build();
        }
    }




