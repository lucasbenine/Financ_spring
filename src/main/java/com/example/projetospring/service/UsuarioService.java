package com.example.projetospring.service;

import com.example.projetospring.mappers.UsuarioMapper;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario listByIdOrThrowBadRequestException(Long id) {
        return usuarioRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Usuario não encontrado, tente novamente"));
    }

    @Transactional
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(usuario));
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.delete(listByIdOrThrowBadRequestException(id));
    }

    public void replaceUsuario(Usuario usuario) {
        Usuario savedUsuario = listByIdOrThrowBadRequestException(usuario.getId());
        Usuario usuario1 = UsuarioMapper.INSTANCE.toUsuario(usuario);
        usuario.setId(savedUsuario.getId());
        usuarioRepository.save(usuario1);
    }
}