package com.example.demo.Mapper;

import com.example.demo.DTO.TodoDTO;
import com.example.demo.Model.Todo;
import com.example.demo.Model.Utente;

public class TodoMapper {
    
    public static TodoDTO toDTO(Todo todo) {
        return TodoDTO.builder()
                .id(todo.getId())
                .descrizione(todo.getDescrizione())
                .completato(todo.isCompletato())
                .utenteId(todo.getUtente().getId())
                .build();
    }

    public static Todo toEntity(TodoDTO dto, Utente utente) {
        return Todo.builder()
                .id(dto.getId())
                .descrizione(dto.getDescrizione())
                .completato(dto.isCompletato())
                .utente(utente)
                .build();
    }
}
