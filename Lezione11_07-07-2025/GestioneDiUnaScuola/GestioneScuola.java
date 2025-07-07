package GestioneDiUnaScuola;

import java.util.ArrayList;
//creo una classe gestione scuola che gestisce tutto il processo di creazione e stampa
public class GestioneScuola {
    //al suo interno dichiaro un arrayList
    ArrayList<Persona> scolaresca;
    //costruttore
    public GestioneScuola() {
        scolaresca = new ArrayList<>();
    }
    //metodo per aggiungere studente
    public void addStudente(String nome, int età, String classe){
        //creo l'oggetto
        Studente studente = new Studente(nome, età, classe);
        //lo aggiungo all'arrayList
        scolaresca.add(studente);
    }
    //metodo per aggiungere docente
    public void addDocente(String nome, int età, String materia){
        //creo l'oggetto
        Docente docente = new Docente(nome, età, materia);
        //lo aggiungo all'arrayList
        scolaresca.add(docente);
    }
    //metodo di stampa totale
    public void stampaScolaresca() {
        //foreach per ciclare tutta la scolaresca
        for (Persona persona : scolaresca) {
            //stampa le informazioni di base
            persona.stampaInfo();
            //richiamo il suo metodo descrivi ruolo
            persona.descriviRuolo();
            //se l'oggetto implementa Registrabile
            if (persona instanceof Registrabile) {
                //richiamane il metodo e stampalo
                ((Registrabile)persona).registrazione();
            }
        }
    }
}
