package com.example.projetospring.repositories;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT new com.example.projetospring.model.CategoriaSoma(obj.categoria, SUM(obj.preco)) " +
            " FROM Despesa AS obj GROUP BY obj.categoria")
    List<CategoriaSoma> amountGroupedByCategoria();

    @Query("SELECT d FROM Despesa d WHERE d.usuario.usuarioId = :id ")
    List<Despesa> despesasbyUsuario(Long id);
}
