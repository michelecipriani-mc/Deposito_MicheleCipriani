package com.example.demo.Controller;

import com.example.demo.DTO.TodoDTO;
import com.example.demo.Service.TodoService;

import lombok.RequiredArgsConstructor;


import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAll() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TodoDTO> create(@RequestBody @Validated TodoDTO dto) {
        return ResponseEntity.ok(todoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable Long id, @RequestBody @Validated TodoDTO dto) {
        return ResponseEntity.ok(todoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}