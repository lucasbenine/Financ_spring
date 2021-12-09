package com.example.projetospring.services;

import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository Urep;

    public Usuario getUsuarioLogado() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String nome;

        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }

        Optional<Usuario> usuario = Urep.findByUsername(nome);

        return usuario.get();
    }

    public List<Usuario> findUsuarios() {
        return Urep.findAll();
    }

    public Usuario findUsuarioID (Long usuarioId){
        Optional<Usuario> obj = Urep.findById(usuarioId);
        return obj.get();
    }

    public Usuario cadastrarUsuario (Usuario usuario){
        return Urep.save(usuario);
    }

    public void deletarUsuario (Long usuarioId){
        Urep.deleteById(usuarioId);
    }

    public Usuario alterarUsuario (Long usuarioId, Usuario obj){
        Usuario entity = Urep.findById(usuarioId).get();
        updateData(entity, obj);
        return Urep.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
    }


}
