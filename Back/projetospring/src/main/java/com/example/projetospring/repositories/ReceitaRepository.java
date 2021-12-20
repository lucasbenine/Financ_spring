package com.example.projetospring.repositories;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receitas, Long> {

    @Query("SELECT new com.example.projetospring.model.CategoriaSoma(obj.categoria, SUM(obj.preco)) " +
            " FROM Receitas AS obj WHERE obj.usuario2.usuarioId = :id GROUP BY obj.categoria")
    List<CategoriaSoma> amountGroupedByCategoria(Long id);

    @Query("SELECT SUM(r.preco) FROM Receitas r WHERE r.usuario2.usuarioId = :id ")
    Double soma(Long id);

    @Query("SELECT r FROM Receitas r WHERE r.usuario2.usuarioId = :id ")
    List<Receitas> receitasByUsuario(Long id);

    @Query("SELECT r FROM Receitas r" +
            " WHERE r.usuario2.usuarioId = :id " +
            "AND EXTRACT (month FROM r.data) = :month " +
            "AND EXTRACT (year FROM r.data) = :year")
    List<Receitas> receitasByMonth(Long id, int month, int year);
}
