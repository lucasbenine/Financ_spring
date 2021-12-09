package com.example.projetospring.controller;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.model.CategoriaReceita;
import com.example.projetospring.repositories.CategoriaReceitaRepository;
import com.example.projetospring.repositories.CategoriaRepository;
import com.example.projetospring.services.CategoriaReceitaService;
import com.example.projetospring.services.CategoriaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/receita-categorias")
public class CategoriaReceitaController {

    @Autowired
    private CategoriaReceitaService service;

    @Autowired
    private CategoriaReceitaRepository repository;

    @GetMapping
    public ResponseEntity<List<CategoriaReceita>> findAll() {
        List<CategoriaReceita> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaReceita> findById(@PathVariable Long id) {
        CategoriaReceita obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<CategoriaReceita> insert(@RequestBody CategoriaReceita categoria) {
        categoria = service.insert(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaReceita> update(@PathVariable Long id, @RequestBody CategoriaReceita categoria) {
        categoria = service.update(id, categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
