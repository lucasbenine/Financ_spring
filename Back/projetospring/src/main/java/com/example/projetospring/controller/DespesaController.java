package com.example.projetospring.controller;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Despesa;
import com.example.projetospring.repositories.DespesaRepository;
import com.example.projetospring.services.DespesaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/despesas")
@Api(value="API - FinanC")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @Autowired
    private DespesaRepository repository;

    @GetMapping
    public ResponseEntity<Page<Despesa>> findAll(Pageable pageable) {
        Page<Despesa> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<Despesa>> findAll() {
        List<Despesa> list = service.findDespesaByUsuario();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/soma")
    public ResponseEntity<Double> soma() {
        Double soma = service.soma();
        return ResponseEntity.ok().body(soma);
    }

    @GetMapping(value = "/soma-mensal")
    public ResponseEntity<Double> somaMensal() {
        Double soma = service.somaMensal();
        return ResponseEntity.ok().body(soma);
    }

    @GetMapping(value = "/anual")
    public ResponseEntity<List<Double>> anual() {
        List<Double> somas = service.despesasAnual();
        return ResponseEntity.ok().body(somas);
    }

    @GetMapping(value = "/month/{month}/{year}")
    public ResponseEntity<List<Despesa>> findByMonth(@PathVariable int month, @PathVariable int year) {
        List<Despesa> despesas = service.findDespesasByMonth(month, year);
        return ResponseEntity.ok().body(despesas);
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
