package Esercizio9;

import java.util.ArrayList;
import java.util.Scanner;

public class SceltaAbbonamento {
    public static void main(String[] args) {
         //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        //ed uno per le stringhe
        Scanner myScannerStr = new Scanner(System.in);
        //creo oggetti
        GestioneAbbonamento gestioneAbbonamento = GestioneAbbonamento.getInstance();
        GestioneStato statoAbbonamento = new GestioneStato();
        AbbonamentoBase abbonamentoBase = new AbbonamentoBase();
        //setto l'aggiornamento attivo
        gestioneAbbonamento.setAbbonamentoAttivo(abbonamentoBase);
        //creo l'arraylist degli extra
        ArrayList<String> extraAttivi = new ArrayList<>();
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("GESTIONE MENU'");
            System.out.println("1 - Aggiungi Extra");
            System.out.println("2 - Rimuovi Extra");
            System.out.println("3 - Visualizza Abbonamento");
            System.out.println("4 - Esci");
            System.out.println("Quale opzione vuoi scegliere?");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 4) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso registro l'aggiunta di un extra
                case 1:
                    //Menù
                    System.out.println("====EXTRA DISPONIBILI====");
                    System.out.println("1 - Premium senza Pubblicità");
                    System.out.println("2 - 4K");
                    System.out.println("Quale vuoi aggiungere?");
                    int risposta = myScannerInt.nextInt();
                    //effttuo una verifica di correttezza della scelta altrimenti richiedo 
                    while (scelta < 1 || scelta > 3) {
                        System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                        risposta = myScannerInt.nextInt();
                    }
                    //gestione della scelta
                    if (risposta == 1) {
                        //verifico di non avere come extra attivo l'abbonamento premium
                        if (!extraAttivi.contains("Abbonamento Premium")) {
                            //creo l'oggetto abbonamento premium
                            AbbonamentoPremium abbonamentoPremium = new AbbonamentoPremium(abbonamentoBase);
                            //aggiungo l'abbonamento premium agli extra
                            extraAttivi.add("Abbonamento Premium");
                            //lo rendo l'abbonamento attivo
                            gestioneAbbonamento.setAbbonamentoAttivo(abbonamentoPremium);
                            //setto lo stato dell'extra ad attivo
                            statoAbbonamento.setStatoAbbonamento(new StatoAttivo("Abbonamento Premium"));
                            // ne richiamo il metodo di attivazione
                            statoAbbonamento.eseguiOperazione();
                        } else {
                            //altrimenti comunico che l'extra è già attivo
                            System.out.println("Errore: Extra già attivo!");
                        }
                    //nel caso di scelta con 4k 
                    } else if (risposta == 2) {
                        //verifico di non avere come extra attivo l'abbonamento premium con 4k
                        if (!extraAttivi.contains("Abbonamento Premium con 4K")) {
                            //creo l'oggetto abbonamento premium con 4k
                            Abbonamento4k abbonamento4K = new Abbonamento4k(abbonamentoBase);
                            //aggiungo l'abbonamento premium con 4k agli extra
                            extraAttivi.add("Abbonamento Premium con 4K");
                            //lo rendo l'abbonamento attivo
                            gestioneAbbonamento.setAbbonamentoAttivo(abbonamento4K);
                            //setto lo stato dell'extra ad attivo
                            statoAbbonamento.setStatoAbbonamento(new StatoAttivo("Abbonamento Premium con 4K"));
                            // ne richiamo il metodo di attivazione
                            statoAbbonamento.eseguiOperazione();
                        } else {
                            //altrimenti comunico che l'extra è già attivo
                            System.out.println("Errore: Extra già attivo!");
                        }
                    }
                    break;
                //nel secondo caso elimino eventuali extra
                case 2:
                    //stampa la lista degli extra
                    System.out.println("====EXTRA ATTIVI====");
                    //verifico se la lista e vuota
                    if (extraAttivi.isEmpty()) {
                        System.out.println("Nessun extra attivo!");
                        break;
                    }
                    //ciclo e stampo tutti gli extra
                    for (String extra : extraAttivi) {
                        System.out.println(" - " + extra);
                    }
                    //chiedo quale extra si vuole rimuovere
                    System.out.println("Quale extra vuoi rimuovere?");
                    //salvo la scelta in una variabile
                    String sceltaRimozione = myScannerStr.nextLine();
                    //elimino l'extra dalla lista
                    extraAttivi.remove(sceltaRimozione);
                    //setto lo stato a disattivo
                    statoAbbonamento.setStatoAbbonamento(new StatoDisattivo(sceltaRimozione));
                    //richiamo il metodo che mi esegue l'operazione
                    statoAbbonamento.eseguiOperazione();
                    //ricompongo l'abbonamento a fine rimozione creo quindi un nuovo abbonamento a fine rimozioni
                    Abbonamento nuovoAbbonamento = new AbbonamentoBase();
                    //ciclo tutti gli extra rimasti
                    for (String extra : extraAttivi) {
                        //switch per gestire l'extra passato
                        switch (extra) {
                            //nel caso abbonamento premium
                            case "Abbonamento Premium":
                                //creo l'oggetto abbonamento premium
                                nuovoAbbonamento = new AbbonamentoPremium(nuovoAbbonamento);
                                break;
                            //nel caso abbonamento premium con 4k
                            case "Abbonamento Premium con 4K":
                                //creo l'oggetto abbonamento premium con 4k
                                nuovoAbbonamento = new Abbonamento4k(nuovoAbbonamento);
                                break;
                        }
                    }
                    //setto la gestione dell'abbonamento e ne passo il nuovo abbonamento settato
                    gestioneAbbonamento.setAbbonamentoAttivo(nuovoAbbonamento);
                    break;
                //nel terzo caso stampo l'abbonamento
                case 3:
                    //setto la variabile abbonamento attuale con il getAbbonamentoAttivo
                    Abbonamento abbonamentoAttuale = gestioneAbbonamento.getAbbonamentoAttivo();
                    //stampo il tipo di abbonamento
                    System.out.println("Tipo Abbonamento: " + abbonamentoAttuale.tipoAbbonamento());
                    //stampo il costo abbonamento
                    System.out.println("Costo Abbonamento: " + abbonamentoAttuale.costoAbbonamento());
                    break;
                //nel caso di default
                default: 
                    //se la scelta è 5 stampo l'uscita
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
