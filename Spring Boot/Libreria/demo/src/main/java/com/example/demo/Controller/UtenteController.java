package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Utente;
import com.example.demo.Service.UtenteService;


@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping
    public List<Utente> getAll() {
        return utenteService.findAll();
    }

    @GetMapping("/{id}")
    public Utente getById(@PathVariable Long id) {
        return utenteService.findById(id).orElse(null);
    }

    @PostMapping
    public Utente create(@RequestBody Utente utente) {
        return utenteService.save(utente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utenteService.deleteById(id);
    }
}