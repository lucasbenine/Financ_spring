package com.example.projetospring.service;


import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository Urep;

    public List<Usuario> findUsuarios() {
        return Urep.findAll();
    }

    public Usuario findUsuarioID (Long id){
        Optional<Usuario> obj = Urep.findById(id);
        return obj.get();
    }

    public Usuario cadastrarUsuario (Usuario usuario){
        return Urep.save(usuario);
    }

    public void deletarUsuario (Long id){
        Urep.deleteById(id);
    }

    public Usuario alterarUsuario (Long id, Usuario obj){
        Usuario entity = Urep.getOne(id);
        updateData(entity, obj);
        return Urep.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
    }


}