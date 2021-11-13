package com.example.projetospring.services;

import com.example.projetospring.model.Categoria;
import com.example.projetospring.repositories.CategoriaRepository;
import com.example.projetospring.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(
                () -> new EntityNotFoundException("Id not found " + id)
        );
    }

    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Categoria update(Long id, Categoria obj) {
        Categoria entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Categoria entity, Categoria obj) {
        entity.setNomeCategoria(obj.getNomeCategoria());
    }
}