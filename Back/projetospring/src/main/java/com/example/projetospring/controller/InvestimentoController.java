package com.example.projetospring.controller;

import com.example.projetospring.model.Investimentos;
import com.example.projetospring.repositories.InvestimentoRepository;
import com.example.projetospring.services.InvestimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/investimentos")
@Api(value="API - FinanC")
public class InvestimentoController {

    @Autowired
    private InvestimentoService service;

    @Autowired
    private InvestimentoRepository repository;

    @ApiOperation(value="Retorna uma lista de investimentos")
    @GetMapping
    public List<Investimentos> listaInvestimentos(){
        return repository.findAll();
    }

    @ApiOperation(value="Cadastra um investimento")
    @PostMapping
    public ResponseEntity<Investimentos> investimentos (@RequestBody Investimentos investimentos){
        investimentos = service.inserirInvestimento(investimentos);
        return ResponseEntity.ok().body(investimentos);
    }

    @ApiOperation(value="Atualiza um investimento cadastrado")
    @PutMapping(value = "/{Id}")
    public ResponseEntity<Investimentos> investimentos (@PathVariable Long Id, @RequestBody Investimentos investimentos){
        investimentos = service.editarInvestimento(Id,investimentos);
        return ResponseEntity.ok().body(investimentos);
    }

    @ApiOperation(value="Deleta um investimento")
    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<Void> deletarInvestimento(@PathVariable Long Id) {
        service.deletarInvestimento(Id);
        return ResponseEntity.noContent().build();
    }
}
