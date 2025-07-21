package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CalcolatriceService;

@RestController
public class DemoCalcolatrice {
    
    private final CalcolatriceService calcolatriceService;
    
    @Autowired
    public DemoCalcolatrice(CalcolatriceService calcolatriceService) {
        this.calcolatriceService = calcolatriceService;
    }

    @GetMapping("/somma")
    public int somma(@RequestParam int a, @RequestParam int b) {
        return calcolatriceService.somma(a, b);
    }

    
}
