package GestioneDiUnaScuola;

import java.util.ArrayList;

public class GestioneScuola {
    ArrayList<Persona> scolaresca;

    public GestioneScuola() {
        scolaresca = new ArrayList<>();
    }

    public void addStudente(String nome, int età, String classe){
        Studente studente = new Studente(nome, età, classe);
        scolaresca.add(studente);
    }

    public void addDocente(String nome, int età, String materia){
        Docente docente = new Docente(nome, età, materia);
        scolaresca.add(docente);
    }

    public void stampaScolaresca() {
        for (Persona persona : scolaresca) {
            persona.stampaInfo();
            if (persona instanceof Studente) {
                persona.descriviRuolo();
                ((Studente)persona).registrazione();
            } else if (persona instanceof Docente) {
                persona.descriviRuolo();
                ((Docente)persona).registrazione();
            }
        }
    }
}
