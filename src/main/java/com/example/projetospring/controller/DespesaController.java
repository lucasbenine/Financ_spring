package com.example.projetospring.controller;


import com.example.projetospring.model.Despesa;
import com.example.projetospring.service.DespesaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/despesas")
@Api(value="API - FinanC")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity<List<Despesa>> findAll() {

        List<Despesa> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value="Retorna uma lista de despesas")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Despesa> findById(@PathVariable Long id) {
        Despesa obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value="Cadastra uma despesa")
    @PostMapping
    public ResponseEntity<Despesa> insert(@RequestBody Despesa despesa) {
        despesa = service.insert(despesa);
        return ResponseEntity.ok().body(despesa);
    }

    @ApiOperation(value="Atualiza uma despesa cadastrada")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
        despesa = service.update(id, despesa);
        return ResponseEntity.ok().body(despesa);
    }

    @ApiOperation(value="Deleta uma despesa")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
