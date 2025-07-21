package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class MessaggioService {
    public void saluta() {
        System.out.println("Ciao dal servizio!");
    }
}
