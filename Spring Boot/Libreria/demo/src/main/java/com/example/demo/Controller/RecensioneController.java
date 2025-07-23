package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.Recensione;
import com.example.demo.Service.RecensioneService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/recensioni")
@RequiredArgsConstructor
public class RecensioneController {
    private final RecensioneService recensioneService;

    @GetMapping
    public List<Recensione> getAllRecensioni() {
        return recensioneService.findAll();
    }

    @GetMapping("/{id}")
    public Recensione getRecensioniById(@PathVariable Long id) {
        return recensioneService.findById(id);
    }

    @PostMapping
    public Recensione createRecensioni(@RequestBody Recensione recensione) {
        return recensioneService.save(recensione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecensioni(@PathVariable Long id) {
        recensioneService.delete(id);
        return ResponseEntity.ok("Recensione eliminata");
    }
}
