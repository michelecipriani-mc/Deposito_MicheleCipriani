package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByAutoreId(Long autoreId);
}
