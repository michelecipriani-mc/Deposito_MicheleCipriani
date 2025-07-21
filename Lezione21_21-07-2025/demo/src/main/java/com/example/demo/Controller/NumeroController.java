package com.example.demo.Controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Numero;

@RestController
@RequestMapping("/numeri")
public class NumeroController {
    private List<Numero> numeri = new ArrayList<>();
    private Long idCounter = 1L;
    
    @GetMapping
    public ResponseEntity<List<Numero>> getAll() {
        return ResponseEntity.ok(numeri);
    }
    
    @GetMapping("/sommaTotale")
    public ResponseEntity<Integer> sommaTotale() {
        int sommaNumeri = 0;
        for (Numero numero : numeri) {
            sommaNumeri += numero.getNumero();
        }
        // return numeri.stream().mapToInt(Numero::getNumero).sum();
        return ResponseEntity.ok(sommaNumeri);
    }

    @PostMapping
    public ResponseEntity<Numero> crea(@RequestBody Numero nuovoNumero) {
        nuovoNumero.setId(idCounter++);
        numeri.add(nuovoNumero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoNumero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Numero> getById(@PathVariable Long id) {
        return numeri.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst().map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Numero> aggiorna(@PathVariable Long id, @RequestBody Numero numeroModificato) {
        for (Numero numero : numeri) {
            if (numero.getId().equals(id)) {
                numero.setNumero(numeroModificato.getNumero());
                return ResponseEntity.ok(numero);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        numeri.removeIf(n -> n.getId().equals(id));
        return "Numero eliminato con successo.";
    }
}
