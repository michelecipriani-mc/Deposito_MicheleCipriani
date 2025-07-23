package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.TodoDTO;
import com.example.demo.Mapper.TodoMapper;
import com.example.demo.Model.Todo;
import com.example.demo.Model.Utente;
import com.example.demo.Repository.TodoRepository;
import com.example.demo.Repository.UtenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UtenteRepository utenteRepository;

    public List<TodoDTO> getAll() {
        return todoRepository.findAll().stream()
                .map(TodoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TodoDTO getById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        return TodoMapper.toDTO(todo);
    }

    public List<Todo> findByUtenteId(Long id) {
        return todoRepository.findByUtenteId(id);
    }

    public TodoDTO create(TodoDTO dto) {
        Utente utente = utenteRepository.findById(dto.getUtenteId())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Todo todo = TodoMapper.toEntity(dto, utente);
        Todo saved = todoRepository.save(todo);
        return TodoMapper.toDTO(saved);
    }

    public TodoDTO update(Long id, TodoDTO dto) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        Utente utente = utenteRepository.findById(dto.getUtenteId())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        todo.setDescrizione(dto.getDescrizione());
        todo.setCompletato(dto.isCompletato());
        todo.setUtente(utente);

        Todo updated = todoRepository.save(todo);
        return TodoMapper.toDTO(updated);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
