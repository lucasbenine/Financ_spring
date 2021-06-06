package com.example.projetospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetospring.model.Usuario;
import com.example.projetospring.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario inserirUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public void deletarUsuario(Long Id) {
		repository.deleteById(Id);
	}
}
