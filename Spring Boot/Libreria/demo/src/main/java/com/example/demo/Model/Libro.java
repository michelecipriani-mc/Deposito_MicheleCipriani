package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private Long id;
    private String titolo;
    private String autore;
    private double prezzo;

}
