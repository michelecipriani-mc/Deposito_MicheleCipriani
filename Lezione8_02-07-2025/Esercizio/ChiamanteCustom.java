package Esercizio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChiamanteCustom {
    public static void main(String[] args) {
        //eseguo un try catch con parametro autoconcludente scanner
        try (Scanner myScanner = new Scanner(System.in)) {
            int risposta;
            //uso un ciclo do while per le operazioni da effettuare
            do {
                //stampo la scelta
                System.out.println("Procedere con la divisione?");
                //valorizzo la scelta con il metodo controlla numero che mi permette di proseguire e valorizzare risposta solo se la scelta dell'utente ricade tra 1 o 2
                risposta = controllaNumero(myScanner, "1 - SI\n2 - NO");

                //utilizzo uno switch per gestire la risposta
                switch (risposta) {
                    //caso uno eseguo l'operazione
                    case 1:
                    //faccio un try catch per gestire eventuali errori
                        try {
                            //chiedo il primo numero
                            System.out.println("Inserisci numero");
                            // lo valorizzo nella variabile x
                            int x = myScanner.nextInt();
                            //chiamo l'eccezione personalizzata che mi verifica se il numero è positvo 
                            Controller.checkPositive(x);
                            //chiedo il secondo numero
                            System.out.println("Inserisci numero");
                            // lo valorizzo nella variabile x
                            int y = myScanner.nextInt();
                            //chiamo l'eccezione personalizzata che mi verifica se il numero è diverso da 0
                            Controller.checkNotZero(y);
                            // restituisco la risposta
                            System.out.println(x + " / " + y + " = " + (x / y));
                        //nel catch gestisco l'eventuale eccezione di numero negativo o dividendo pari a 0
                        } catch (NumeroNegativoException | NumeroZeroException e) {
                            //stampo il messaggio personalizzato di errore
                            System.out.println("Attenzione! " + e.getMessage());
                        }  
                        break;
                    default: 
                        //nel default si l'utente ha selezionato 2 stampo la chiusura del programma
                        if (risposta == 2) {
                            System.out.println("Programma terminato!");
                        //altrimenti stampo l'errore nell'inserimento dell'input
                        } else {
                            System.out.println("Errore: inserisci un numero valido");
                        }
                        break;
                }  
            } while (risposta != 2); //verifico la condizione di uscita dal ciclo
        //gestione di un eventuale errore non previsto
        } catch (Exception e) {
            //stampo l'errore con printstacktrace
            System.out.println("Errore non previsto!");
            e.printStackTrace();
        }
    }

    //creo il metodo privato che controlla il numero
    private static int controllaNumero(Scanner scanner, String message) {
        //utilizzo un ciclo do while per la ripezione
        do {
            //stampo il messaggio passato per la selezione
            System.out.println(message);
            //con un try catch monitoro l'inserimento dell'input
            try {
                //valido la variabile x con l'input
                int x = scanner.nextInt();
                //e la restituisco
                return x;
            } catch (InputMismatchException e) {
                //nel caso di errore richiedo il numero
               System.out.println("Inserisci u numero: ");
            }
        } while (true); //verifico la condizione di uscita
    }
}
