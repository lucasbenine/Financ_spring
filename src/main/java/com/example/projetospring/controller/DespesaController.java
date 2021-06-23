package com.example.projetospring.controller;


import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Despesa;
import com.example.projetospring.service.DespesaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity<Page<Despesa>> findAll(Pageable pageable) {

        Page<Despesa> list = service.findAll(pageable);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/amount-by-categoria")
    public ResponseEntity<List<CategoriaSoma>> amountGroupedByCategoria() {
        List<CategoriaSoma> list = service.amountGroupedByCategoria();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value="Retorna uma lista de despesas")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Despesa> findById(@PathVariable Long id) {
        Despesa obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Despesa> insert(@RequestBody Despesa despesa) {
        despesa = service.insert(despesa);
        return ResponseEntity.ok().body(despesa);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
        despesa = service.update(id, despesa);
        return ResponseEntity.ok().body(despesa);
    }
}
