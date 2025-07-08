package EsercizioObserver2;

import java.util.Scanner;

public class Borsa {
    public static void main(String[] args) {
        //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        //ed uno per le stringhe
        Scanner myScannerStr = new Scanner(System.in);
        //creo l'oggetto borsa
        AgenziaBorsa borsa = new AgenziaBorsa("Vendite", 1000);
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("GESTIONE BORSA");
            System.out.println("1 - Aggiungi investitore privato");
            System.out.println("2 - Aggiungi investitore bancario");
            System.out.println("3 - Registra modifica");
            System.out.println("4 - Stampa investitori");
            System.out.println("5 - Esci");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 5) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso registro investitore privato
                case 1:
                    //chiedo i dati e li salvo nella variabili
                    System.out.println("Inserisci nome investitore:");
                    String nome = myScannerStr.nextLine();
                    //creo l'investitore privato
                    InvestitorePrivato investitorePrivato = InvestitorePrivato.getInstance(nome);
                    //aggiungo l'investitore privato
                    borsa.addInvestitore(investitorePrivato);
                    break;
                //nel secondo caso registro investitore bancario
                case 2:
                    //chiedo i dati e li salvo nella variabili
                    System.out.println("Inserisci nome investitore:");
                    String name = myScannerStr.nextLine();
                    System.out.println("Inserisci nome banca:");
                    String bank = myScannerStr.nextLine();
                    //creo l'investitore bancario
                    InvestitoreBancario investitoreBancario = InvestitoreBancario.getInstance(name, bank);
                    //aggiungo l'investitore bancario
                    borsa.addInvestitore(investitoreBancario);
                    break;
                //nel terzo caso stampo la modifica dell'azione
                case 3:
                    //chiedo i dati e li salvo nella variabili
                    System.out.println("Inserisci il nome dell'azione revisionata:");
                    String nomeAzione = myScannerStr.nextLine();
                    System.out.println("Inserisci nuovo valore:");
                    double valore = myScannerInt.nextDouble();
                    //setto i nuovi valori in agenzia
                    borsa.setNome(nomeAzione);
                    borsa.setValore(valore);
                    //creo l'oggetto azione e richiamo quindi il metodo per notificare il cambio dell'azione
                    Azione azione = new Azione();
                    azione.notifica(nomeAzione, valore);
                    break;
                //nel quarto caso stampo tutti gli investitori 
                case 4:
                    borsa.notificaObservers(); //invio la variazione anche agli investitori
                    break;
                //nel caso di default
                default: 
                    //se la scelta è 5 stampo l'uscita
                    if (scelta == 5) {
                        System.out.println("Programma terminato!");
                    //altrimenti stampo l'errore
                    } else {
                        System.out.println("Errore: comando non valido, inserisci un comando valido:");
                    }
                    break;
            }
        } while (scelta != 5); //controllo lo stato della condizione
        //chiusura degli scanner
        myScannerStr.close();
        myScannerInt.close();
    }
}
