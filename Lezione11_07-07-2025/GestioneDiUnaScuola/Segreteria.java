package GestioneDiUnaScuola;

import java.util.Scanner;

public class Segreteria {
    public static void main(String[] args) {
        Scanner myScannerInt = new Scanner(System.in);
        Scanner myScannerStr = new Scanner(System.in);

        GestioneScuola scuola = new GestioneScuola();
        int scelta;
        do {
            System.out.println("GESTIONE REGISTRAZIONI");
            System.out.println("1 - Registra iscrizione Studente");
            System.out.println("2 - Registra iscrizione Docente");
            System.out.println("3 - Stampa docenti e Studenti");
            System.out.println("4 - Esci");
            scelta = myScannerInt.nextInt();

            while (scelta < 1 || scelta > 4) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci nome Studente:");
                    String nome = myScannerStr.nextLine();
                    System.out.println("Inserisci età studente: ");
                    int età = myScannerInt.nextInt();
                    System.out.println("Inserisci la classe dello studente: ");
                    String classe = myScannerStr.nextLine();
                    scuola.addStudente(nome, età, classe);
                    break;
                case 2:
                    System.out.println("Inserisci nome Docente:");
                    String nomeDocente = myScannerStr.nextLine();
                    System.out.println("Inserisci età Docente: ");
                    int etàDocente = myScannerInt.nextInt();
                    System.out.println("Inserisci materia insegnata: ");
                    String materia = myScannerStr.nextLine();
                    scuola.addDocente(nomeDocente, etàDocente, materia);
                    break;
                case 3:
                    scuola.stampaScolaresca();
                    break;
                default: 
                    if (scelta == 4) {
                        System.out.println("Programma terminato!");
                    } else {
                        System.out.println("Errore: comando non valido, inserisci un comando valido:");
                    }
                    break;
            }
        } while (scelta != 4);

        myScannerStr.close();
        myScannerInt.close();
    }
}
