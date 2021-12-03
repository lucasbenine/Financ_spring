package com.example.projetospring.repositories;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receitas, Long> {

    @Query("SELECT new com.example.projetospring.model.CategoriaSoma(obj.categoria, SUM(obj.preco)) " +
            " FROM Receitas AS obj WHERE obj.usuario2.usuarioId = 2 GROUP BY obj.categoria")
    List<CategoriaSoma> amountGroupedByCategoria();

    @Query("SELECT SUM(r.preco) FROM Receitas r WHERE r.usuario2.usuarioId = 2 ")
    Double soma();
}
