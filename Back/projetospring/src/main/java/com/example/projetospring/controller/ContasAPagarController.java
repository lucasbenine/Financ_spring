package com.example.projetospring.controller;


import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.repositories.ContasAPagarRepository;
import com.example.projetospring.services.ContasAPagarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contasapagar")
@Api(value="API - FinanC")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService service;

    @Autowired
    private ContasAPagarRepository repository;

    @ApiOperation(value="Retorna uma lista de contas a serem pagas")
    @GetMapping
    public List<ContasAPagar> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<ContasAPagar> findById(@PathVariable Long id){
        ContasAPagar obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/amount-by-categoria")
    public ResponseEntity<List<CategoriaSoma>> amountGroupedByCategoria() {
        List<CategoriaSoma> list = service.amountGroupedByCategoria();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value="Cadastra uma conta a ser paga")
    @PostMapping
    public ResponseEntity<ContasAPagar> inserirConta (@RequestBody ContasAPagar contasapagar){
        contasapagar = service.inserir(contasapagar);
        return ResponseEntity.ok().body(contasapagar);
    }

    @ApiOperation(value="Atualiza uma conta cadastrada para pagamento")
    @PutMapping(value = "/{Id}")
    public ResponseEntity<ContasAPagar> editarConta (@PathVariable Long Id, @RequestBody ContasAPagar contasapagar){
        contasapagar = service.editarConta(Id,contasapagar);
        return ResponseEntity.ok().body(contasapagar);
    }

    @ApiOperation(value="Deleta uma conta a pagar")
    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long Id) {
        service.deletarConta(Id);
        return ResponseEntity.noContent().build();
    }
}
