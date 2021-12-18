package com.example.projetospring.services;


import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.ContasAPagarRepository;
import com.example.projetospring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioLogado() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String nome;

        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }

        Optional<Usuario> usuario = usuarioRepository.findByUsername(nome);

        return usuario.get();
    }

    public List<ContasAPagar> findAll (){
        Usuario usuario = getUsuarioLogado();
        return repository.contasByUsuario(usuario.getUsuarioId());
    }

    public ContasAPagar findById(Long id){
        Optional<ContasAPagar> obj = repository.findById(id);
        return obj.get();
    }

    @Transactional(readOnly = true)
    public List<CategoriaSoma> amountGroupedByCategoria() {
        Usuario usuario = getUsuarioLogado();
        List<CategoriaSoma> categoriaSoma = repository.amountGroupedByCategoria(usuario.getUsuarioId());
        return categoriaSoma;
    }

    public ContasAPagar inserir (ContasAPagar contasapagar){
        Usuario usuario = getUsuarioLogado();
        contasapagar.setUsuario(usuario);
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
