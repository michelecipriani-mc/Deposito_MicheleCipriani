package EsercizioStrategy;

import java.util.Scanner;

public class ExeOperazioni {
    public static void main(String[] args) {
         //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("===OPERAZIONI===");
            System.out.println("1 - ADDIZIONA");
            System.out.println("2 - MOLTIPLICA");
            System.out.println("3 - ESCI");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 3) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso gestisco l'addizione
                case 1:
                    //chiedo il primo valore
                    System.out.println("Inserisci primo valore:");
                    int a = myScannerInt.nextInt();
                    //chiedo il secondo valore
                    System.out.println("Inserisci secondo valore:");
                    int b = myScannerInt.nextInt();

                    Calcolatore calcolatore = new Calcolatore();
                    calcolatore.setOperazione(new Addizione());
                    calcolatore.strategia(a, b);

                    break;
                //nel secondo caso gestisco la moltiplicazione
                case 2:
                    //chiedo il primo valore
                    System.out.println("Inserisci primo valore:");
                    int x = myScannerInt.nextInt();
                    //chiedo il secondo valore
                    System.out.println("Inserisci secondo valore:");
                    int y = myScannerInt.nextInt();

                    Calcolatore calcolatoreX = new Calcolatore();
                    calcolatoreX.setOperazione(new Moltiplicazione());
                    calcolatoreX.strategia(x, y);
                    break;
                //nel caso di default
                default: 
                    //se la scelta è 3 stampo l'uscita
                    if (scelta == 3) {
                        System.out.println("Programma terminato!");
                    //altrimenti stampo l'errore
                    } else {
                        System.out.println("Errore: comando non valido, inserisci un comando valido:");
                    }
                    break;
            }
        } while (scelta != 3); //controllo lo stato della condizione
        //chiusura degli scanner
        myScannerInt.close();
    }
}
