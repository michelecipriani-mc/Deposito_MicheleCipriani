package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo", nullable = false, length = 50)
    @NotBlank(message = "Il titolo è obbligatorio!")
    private String titolo;

    @Column(name = "prezzo", nullable = false)
    @DecimalMin(value = "5.00", inclusive = true, message = "Il prezzo è obbligatorio, ed il minimo e 5.00 euro")
    @DecimalMax(value = "100.00", inclusive = false, message = "Il prezzo è obbligatorio, ed il massimo e 99.99 euro")
    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Recensione> recensioni;
}
