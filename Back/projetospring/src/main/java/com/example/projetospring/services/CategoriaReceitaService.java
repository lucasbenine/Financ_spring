package com.example.projetospring.services;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.model.CategoriaReceita;
import com.example.projetospring.repositories.CategoriaReceitaRepository;
import com.example.projetospring.repositories.CategoriaRepository;
import com.example.projetospring.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaReceitaService {

    @Autowired
    private CategoriaReceitaRepository repository;

    public List<CategoriaReceita> findAll() {
        return repository.findAll();
    }

    public CategoriaReceita findById(Long id) {
        Optional<CategoriaReceita> obj = repository.findById(id);
        return obj.orElseThrow(
                () -> new EntityNotFoundException("Id not found " + id)
        );
    }

    public CategoriaReceita insert(CategoriaReceita categoria) {
        return repository.save(categoria);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CategoriaReceita update(Long id, CategoriaReceita obj) {
        CategoriaReceita entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(CategoriaReceita entity, CategoriaReceita obj) {
        entity.setNomeCategoria(obj.getNomeCategoria());
    }
}
