package com.example.demo.Model;

public class Numero {
    private Long id;
    private int numero;

    // Costruttori
    public Numero() {}
    public Numero(Long id, int numero) {
        this.id = id;
        this.numero= numero;
    }

    // Getter e Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

}
