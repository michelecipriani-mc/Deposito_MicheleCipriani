package GestioneDiUnaScuola;

import java.util.Scanner;

public class Segreteria {
    public static void main(String[] args) {
        //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        //ed uno per le stringhe
        Scanner myScannerStr = new Scanner(System.in);
        //creo l'oggetto scuola
        GestioneScuola scuola = new GestioneScuola();
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("GESTIONE REGISTRAZIONI");
            System.out.println("1 - Registra iscrizione Studente");
            System.out.println("2 - Registra iscrizione Docente");
            System.out.println("3 - Stampa docenti e Studenti");
            System.out.println("4 - Esci");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 4) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso registro lo studente
                case 1:
                    //chiedo i dati e li salvo nella variabili
                    System.out.println("Inserisci nome Studente:");
                    String nome = myScannerStr.nextLine();
                    System.out.println("Inserisci età studente: ");
                    int età = myScannerInt.nextInt();
                    System.out.println("Inserisci la classe dello studente: ");
                    String classe = myScannerStr.nextLine();
                    //dopodichè richiamo il metodo aggiungi studente dell'oggeto scuola e ne passo i parametri per la costruzione dell'oggetto
                    scuola.addStudente(nome, età, classe);
                    break;
                //nel secondo caso registro il docente
                case 2:
                    //chiedo i dati e li salvo nella variabili
                    System.out.println("Inserisci nome Docente:");
                    String nomeDocente = myScannerStr.nextLine();
                    System.out.println("Inserisci età Docente: ");
                    int etàDocente = myScannerInt.nextInt();
                    System.out.println("Inserisci materia insegnata: ");
                    String materia = myScannerStr.nextLine();
                    //dopodichè richiamo il metodo aggiungi docente dell'oggeto scuola e ne passo i parametri per la costruzione dell'oggetto
                    scuola.addDocente(nomeDocente, etàDocente, materia);
                    break;
                //nel terzo caso stampo tutta la scolaresca
                case 3:
                    //richiamo quindi il metodo stampa scolaresca
                    scuola.stampaScolaresca();
                    break;
                //nel caso di default
                default: 
                    //se la scelta è 4 stampo l'uscita
                    if (scelta == 4) {
                        System.out.println("Programma terminato!");
                    //altrimenti stampo l'errore
                    } else {
                        System.out.println("Errore: comando non valido, inserisci un comando valido:");
                    }
                    break;
            }
        } while (scelta != 4); //controllo lo stato della condizione
        //chiusura degli scanner
        myScannerStr.close();
        myScannerInt.close();
    }
}
