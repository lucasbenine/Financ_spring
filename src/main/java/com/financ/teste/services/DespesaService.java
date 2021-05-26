package com.financ.teste.services;

import com.financ.teste.entities.Despesa;
import com.financ.teste.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository repository;

    public List<Despesa> findAll() {
        return repository.findAll();
    }

    public Despesa findById(Long id) {
        Optional<Despesa> obj = repository.findById(id);
        return obj.get();
    }

}