package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByLibroId(Long libroId);
}
