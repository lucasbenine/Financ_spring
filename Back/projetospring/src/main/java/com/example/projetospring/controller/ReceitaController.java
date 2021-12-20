package com.example.projetospring.controller;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Despesa;
import com.example.projetospring.model.Receitas;
import com.example.projetospring.repositories.ReceitaRepository;
import com.example.projetospring.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService rServ;

    @Autowired
    private ReceitaRepository repository;

    @GetMapping
    public List<Receitas> listaReceitas() {
        return rServ.listReceitas();
    }

    @GetMapping(value = "/soma")
    public ResponseEntity<Double> soma() {
        Double soma = rServ.soma();
        return ResponseEntity.ok().body(soma);
    }

    @GetMapping(value = "/month/{month}/{year}")
    public ResponseEntity<List<Receitas>> findByMonth(@PathVariable int month, @PathVariable int year) {
        List<Receitas> receitas = rServ.findReceitasByMonth(month, year);
        return ResponseEntity.ok().body(receitas);
    }

    @GetMapping(value = "/amount-by-categoria")
    public ResponseEntity<List<CategoriaSoma>> amountGroupedByCategoria() {
        List<CategoriaSoma> list = rServ.amountGroupedByCategoria();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Receitas> cadastrarReceita(@RequestBody Receitas receitas){
        receitas = rServ.cadastroReceita(receitas);
        return ResponseEntity.ok().body(receitas);
    }

    @GetMapping(value = "/{id}" )
    public ResponseEntity<Receitas> findReceitaById(@PathVariable Long id){
        Receitas obj = rServ.findReceitaById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Receitas> alterarReceita(@RequestBody Receitas receitas, @PathVariable Long id){
        receitas = rServ.alterarReceita(id, receitas);
        return ResponseEntity.ok().body(receitas);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable Long id){
        rServ.deleteReceita(id);
        return ResponseEntity.noContent().build();

    }
}
