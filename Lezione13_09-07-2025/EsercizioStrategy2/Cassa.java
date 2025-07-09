package EsercizioStrategy2;

import java.util.Scanner;

public class Cassa {
    public static void main(String[] args) {
        //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        //Inizializzo l'oggeto pagamento
        Pagamento pagamento = Pagamento.getInstance();
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("Salve, come intende pagare?");
            System.out.println("1 - Carta di credito");
            System.out.println("2 - PayPal");
            System.out.println("3 - ESCI");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 3) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            double importo = 100.00;
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso gestisco la CDC
                case 1:
                    //se l'importo da pagare è maggiore di 25€ chiedo il pin
                    if (importo >= 25) {
                        //creo l'oggetto decoretor
                        MetodoPagamento conPin = new CDCPIN(new CDC());
                        //lo passo in pagamento richiamando il metodo set
                        pagamento.setMetodoPagamento(conPin);
                    //altrimenti non chiedo il pin
                    } else {
                        //creo l'oggetto CDC e lo passo direttamente nel metodo set metodo pagamento
                        pagamento.setMetodoPagamento(new CDC());
                    }
                    //successivamenta alla verifica richiamo il metodo strategia
                    pagamento.strategia(importo);
                    break;
                //nel secondo caso gestisco PayPal
                case 2:
                    //creo l'oggetto PayPal e lo passo direttamente nel metodo set metodo pagamento
                    pagamento.setMetodoPagamento(new PayPal());
                    //richiamo il metodo strategia
                    pagamento.strategia(importo);
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
        //chiusura scanner
        myScannerInt.close();
    }
}
