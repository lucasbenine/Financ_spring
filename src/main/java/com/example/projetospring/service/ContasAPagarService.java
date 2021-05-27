package com.example.projetospring.service;

import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository repository;

    public ContasAPagar inserir (ContasAPagar contasapagar){
        return repository.save(contasapagar);

    }
}
