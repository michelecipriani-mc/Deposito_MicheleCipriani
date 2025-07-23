package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Recensione;
import com.example.demo.Repository.RecensioneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    public List<Recensione> findAll() {
        return recensioneRepository.findAll();
    }

    public List<Recensione> findByTodoId(Long libroId) {
        return recensioneRepository.findByLibroId(libroId);
    }

    public Recensione findById(Long id) {
        return recensioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Commento non trovato"));
    }

    public Recensione save(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public void delete(Long id) {
        recensioneRepository.deleteById(id);
    }
    
}
