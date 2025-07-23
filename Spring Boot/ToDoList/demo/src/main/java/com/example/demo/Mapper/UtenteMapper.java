package com.example.demo.Mapper;

import com.example.demo.DTO.UtenteDTO;
import com.example.demo.Model.Utente;

public class UtenteMapper {
    
    public static UtenteDTO toDTO(Utente utente) {
        return UtenteDTO.builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .todoList(
                    utente.getTodoList().stream()
                        .map(TodoMapper::toDTO)
                        .toList()
                )
                .build();
    }
}
