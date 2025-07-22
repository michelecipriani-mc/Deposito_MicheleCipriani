package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Commento;

public interface CommentoRepository extends JpaRepository<Commento, Long> {
    List<Commento> findByTodoId(Long todoId);
}