package com.example.projetospring.repositories;

import com.example.projetospring.model.ContasAReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceber, Long> {
}
