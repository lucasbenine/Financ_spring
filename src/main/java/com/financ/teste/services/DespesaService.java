package com.financ.teste.services;

import com.financ.teste.entities.Categoria;
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

    public Despesa insert(Despesa despesa) {
        return repository.save(despesa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Despesa update(Long id, Despesa obj) {
        Despesa entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Despesa entity, Despesa obj) {
        entity.setNome(obj.getNome());
        entity.setPreco(obj.getPreco());
        entity.setData(obj.getData());
        entity.setDescricao(obj.getDescricao());
        entity.setCategoria(obj.getCategoria());
    }

}