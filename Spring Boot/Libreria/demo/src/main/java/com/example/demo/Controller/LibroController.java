package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.Libro;
import com.example.demo.Model.Recensione;
import com.example.demo.Service.LibroService;
import com.example.demo.Service.RecensioneService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/libreria/libri")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;
    private final RecensioneService recensioneService;

    @GetMapping
    public List<Libro> getAllLibro() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public Libro createLibro(@RequestBody @Valid Libro todo) {
        return libroService.save(todo);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody @Valid Libro modificato) {
        Libro esistente = libroService.findById(id);
        esistente.setTitolo(modificato.getTitolo());
        esistente.setPrezzo(modificato.getPrezzo());
        return libroService.save(esistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.ok("Libro eliminato");
    }

    //ENDPOINT SPECIFICO: tutte le recensioni collegate al libro
    @GetMapping("/{id}/recensioni")
    public List<Recensione> getRecensioneByLibro(@PathVariable Long id) {
        return recensioneService.findByTodoId(id);
    }

}
