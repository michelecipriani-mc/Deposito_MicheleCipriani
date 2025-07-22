package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Commento;
import com.example.demo.Service.CommentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/commenti")
@RequiredArgsConstructor
public class CommentoController {

    private final CommentoService commentoService;

    @GetMapping
    public List<Commento> getAllCommenti() {
        return commentoService.findAll();
    }

    @GetMapping("/{id}")
    public Commento getCommentoById(@PathVariable Long id) {
        return commentoService.findById(id);
    }

    @PostMapping
    public Commento createCommento(@RequestBody Commento commento) {
        return commentoService.save(commento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommento(@PathVariable Long id) {
        commentoService.delete(id);
        return ResponseEntity.ok("Commento eliminato");
    }
}
