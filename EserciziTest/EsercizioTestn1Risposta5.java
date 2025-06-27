/* 
Traccia: Controllo idoneità per un corso avanzato
Scrivi un programma Java che chieda all’utente: 
 
 La sua età 
 
 Il numero di anni di esperienza in programmazione 
 
 Il numero di certificazioni ottenute 
 
 Il programma deve verificare se l’utente può accedere a un corso avanzato secondo questi criteri: 
 
 Deve avere più di 18 anni 
 
 E almeno 2 anni di esperienza 
 
 Oppure se ha almeno 1 certificazione e un’età compresa tra 16 e 18 anni (inclusi) 
 
 Inoltre, calcola e stampa la radice quadrata del numero totale di anni (età + esperienza), usando Math.sqrt. Stampa: 
 
 "Idoneo al corso" se soddisfa le condizioni 
 
 "Non idoneo al corso" altrimenti */

import java.util.Scanner;

public class EsercizioTestn1Risposta5 {
    public static void main(String[] args) {

        //inizializzazione variabile idoneità
        boolean suitable = false;

        //dichiarazione Scanner
        Scanner myScanner = new Scanner(System.in);

        //output guida
        System.out.println("Inserire la propria età: ");
        //inizializzazione età
        int age = myScanner.nextInt();

        // controllo età valida
        while (age <= 0) {
            System.out.println("Inserire età valida: ");
            age = myScanner.nextInt();
        }

        //output guida
        System.out.println("Inserire il numero di anni di esperienza in programmazione: ");
        //inizializzazione esperienza
        int experience = myScanner.nextInt();

        //output guida
        System.out.println("Inserire il numero di certificazioni conseguite: ");
        //inizializzazione certificazioni
        int certifications = myScanner.nextInt();

        if (age >= 18 && experience >= 2) {
            suitable = true;
        } else if (age >= 16 && age <= 18 && certifications != 0) {
            suitable = true;
        }
        
        //variabile radice quadrata
        double radiceQ = Math.sqrt(age + experience);

        //Stampa della radice quadrata
        System.out.println("La radice quadrata dell'età + l'esperienza è: " + radiceQ);

        //verifica e stampa l'ammissione o meno al corso
        if (suitable) {
            System.out.println("Sei idoneo al corso!");
        } else {
            System.out.println("Non sei idoneo al corso!");
        }

        //chiusura scanner
        myScanner.close();
    }
}