package com.example.projetospring.repositories;

import com.example.projetospring.model.Planejamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanejamentoRepository extends JpaRepository<Planejamento, Long> {
}
