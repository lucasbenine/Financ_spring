package com.example.projetospring.repositories;

import com.example.projetospring.model.Investimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimentos, Long> {
}
