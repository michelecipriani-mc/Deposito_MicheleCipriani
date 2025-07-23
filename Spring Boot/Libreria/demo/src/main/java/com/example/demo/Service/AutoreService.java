package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Autore;
import com.example.demo.Repository.AutoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Autore findById(Long id) {
        return autoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Autore non trovato"));
    }

    public Autore save(Autore autore) {
        return autoreRepository.save(autore);
    }

    public void delete(Long id) {
        autoreRepository.deleteById(id);
    }
}
