package com.example.projetospring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projetospring.model.Investimentos;
import com.example.projetospring.repository.InvestimentosRepository;
import com.example.projetospring.service.InvestimentosService;

@RestController
@RequestMapping("/investimentos")
public class InvestimentosController {
	
	@Autowired
	private InvestimentosService service;
	
	@Autowired
	private InvestimentosRepository repository;

	@GetMapping
	public List<Investimentos> listaInvestimentos(){
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Investimentos> investimentos (@RequestBody Investimentos investimentos){
		investimentos = service.inserirInvestimento(investimentos);
		return ResponseEntity.ok().body(investimentos);
	}

	@PutMapping(value = "/{Id}")
	public ResponseEntity<Investimentos> investimentos (@PathVariable Long Id, @RequestBody Investimentos investimentos){
		investimentos = service.editarInvestimento(Id,investimentos);
		return ResponseEntity.ok().body(investimentos);
	}

	@DeleteMapping(value = "/{Id}")
	public ResponseEntity<Void> deletarInvestimento(@PathVariable Long Id) {
		service.deletarInvestimento(Id);
		return ResponseEntity.noContent().build();
	}
}


