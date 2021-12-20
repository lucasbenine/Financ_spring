package com.example.projetospring.repositories;

import com.example.projetospring.model.ContasAPagar;
import com.example.projetospring.model.ContasAReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceber, Long> {

    @Query("SELECT c FROM ContasAReceber c WHERE c.usuario.usuarioId = :id")
    List<ContasAReceber> contasByUsuario(Long id);
}
