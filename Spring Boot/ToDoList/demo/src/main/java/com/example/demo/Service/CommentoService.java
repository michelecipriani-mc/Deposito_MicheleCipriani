package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Commento;
import com.example.demo.Repository.CommentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentoService {

private final CommentoRepository commentoRepository;

public List<Commento> findAll() {
return commentoRepository.findAll();
}

public List<Commento> findByTodoId(Long todoId) {
return commentoRepository.findByTodoId(todoId);
}

public Commento findById(Long id) {
return commentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Commento non trovato"));
}

public Commento save(Commento commento) {
return commentoRepository.save(commento);
}

public void delete(Long id) {
commentoRepository.deleteById(id);
}
}