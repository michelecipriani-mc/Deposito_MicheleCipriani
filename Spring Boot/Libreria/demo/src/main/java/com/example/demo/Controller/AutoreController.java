package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Autore;
import com.example.demo.Model.Libro;
import com.example.demo.Service.AutoreService;
import com.example.demo.Service.LibroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/autore")
@RequiredArgsConstructor
public class AutoreController {

    private final AutoreService autoreService;
    private final LibroService libroService;

    @GetMapping
    public List<Autore> getAllAutore() {
        return autoreService.findAll();
    }

    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable Long id) {
        return autoreService.findById(id);
    }

    @PostMapping
    public Autore createAutore(@RequestBody Autore autore) {
        return autoreService.save(autore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutore(@PathVariable Long id) {
        autoreService.delete(id);
        return ResponseEntity.ok("Autore eliminato");
    }

    //  ENDPOINT SPECIFICO: tutti i libri di un utente
    @GetMapping("/{id}/libro")
    public List<Libro> getLibroByAutore(@PathVariable Long id) {
        return libroService.findByAutorId(id);
    }
    
}
