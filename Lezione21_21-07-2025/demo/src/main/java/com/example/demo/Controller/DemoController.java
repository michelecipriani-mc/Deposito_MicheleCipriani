package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MessaggioService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {
    private final MessaggioService messaggioService;

    @Autowired
    public DemoController(MessaggioService messaggioService) {
        this.messaggioService = messaggioService;
    }

    @GetMapping("/saluta")
    public String saluta() {
        messaggioService.saluta();
        return "Saluto inviato!";
    }
    
}
