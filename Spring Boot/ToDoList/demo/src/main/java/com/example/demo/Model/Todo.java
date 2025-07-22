package com.example.demo.Model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descrizione", nullable = false, length = 100)
    private String descrizione;
    @Column(name = "completato", nullable = false)
    private boolean completato;

    public Todo(String descrizione, boolean completato) {
        this.descrizione = descrizione;
        this.completato = completato;
    }

}
