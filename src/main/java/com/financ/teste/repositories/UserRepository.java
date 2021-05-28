package com.financ.teste.repositories;

import com.financ.teste.entities.Despesa;
import com.financ.teste.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
