package com.example.projetospring.services;


import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository repository;

    public List<ContasAPagar> findAll (){
        return repository.findAll();
    }

    public ContasAPagar findById(Long id){
        Optional<ContasAPagar> obj = repository.findById(id);
        return obj.get();
    }

    @Transactional(readOnly = true)
    public List<CategoriaSoma> amountGroupedByCategoria() {
        List<CategoriaSoma> categoriaSoma = repository.amountGroupedByCategoria();
        return categoriaSoma;
    }

    public ContasAPagar inserir (ContasAPagar contasapagar){
        return repository.save(contasapagar);
    }

    public void deletarConta (Long Id) {
        repository.deleteById(Id);
    }

    public ContasAPagar editarConta (Long Id, ContasAPagar contasapagar) {
        ContasAPagar c1 = repository.findById(Id).get();
        updateData(c1, contasapagar);
        return repository.save(c1);
    }

    private void updateData (ContasAPagar c1, ContasAPagar contasapagar) {
        c1.setNomeConta(contasapagar.getNomeConta());
        c1.setValorConta(contasapagar.getValorConta());
        c1.setCategoria(contasapagar.getCategoria());
    }

}
