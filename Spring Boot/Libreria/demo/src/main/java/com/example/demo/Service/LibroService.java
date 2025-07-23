package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.Model.Libro;
import com.example.demo.Repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroService {
    private final LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public List<Libro> findByAutorId(Long autoreId) {
        return libroRepository.findByAutoreId(autoreId);
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }

}
