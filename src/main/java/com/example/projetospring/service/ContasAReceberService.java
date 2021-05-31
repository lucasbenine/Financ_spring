package com.example.projetospring.service;

import com.example.projetospring.model.ContasAReceber;
import com.example.projetospring.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContasAReceberService {

    @Autowired
    private ContasAReceberRepository repository;

    public ContasAReceber inserir(ContasAReceber contasareceber) {
        return repository.save(contasareceber);
    }


}

