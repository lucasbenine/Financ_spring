package com.example.projetospring.repositories;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT new com.example.projetospring.model.CategoriaSoma(obj.categoria, SUM(obj.preco)) " +
            " FROM Despesa AS obj WHERE obj.usuario.usuarioId = :id GROUP BY obj.categoria")
    List<CategoriaSoma> amountGroupedByCategoria(Long id);

    @Query("SELECT d FROM Despesa d WHERE d.usuario.usuarioId = :id ")
    List<Despesa> despesasbyUsuario(Long id);

    @Query("SELECT d from Despesa d " +
            "WHERE d.usuario.usuarioId = :id " +
            "AND EXTRACT (month FROM d.data) = :month " +
            "AND EXTRACT (year FROM d.data) = :year ")
    List<Despesa> despesasByMonth(Long id, int month, int year);

    @Query("SELECT SUM(d.preco) FROM Despesa d WHERE d.usuario.usuarioId = :id ")
    Double soma(Long id);
}
