package com.example.projetospring.repositories;

import com.example.projetospring.model.Receitas;
import com.example.projetospring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

}
