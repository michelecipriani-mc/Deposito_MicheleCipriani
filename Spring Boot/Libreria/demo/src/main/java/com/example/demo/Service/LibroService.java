package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Libro;
@Service
public class LibroService {
    private final List<Libro> libri = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Libro> getAll() {
        return libri;
    }

    public Optional<Libro> getById(Long id) {
        return libri.stream().filter(libro -> libro.getId().equals(id)).findFirst();
    }

    public Libro create(Libro nuovoLibro) {
        nuovoLibro.setId(idCounter++);
        libri.add(nuovoLibro);
        return nuovoLibro;
    }

    public Optional<Libro> update(Long id, Libro libroModificato) {
        return getById(id).map(libro -> {
            libro.setTitolo(libroModificato.getTitolo());
            libro.setAutore(libroModificato.getAutore());
            libro.setPrezzo(libroModificato.getPrezzo());
            return libro;
        });
    }

    public boolean delete(Long id) {
        return libri.removeIf(libro -> libro.getId().equals(id));
    }
}
