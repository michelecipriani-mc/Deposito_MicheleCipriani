package EsercizioDecorator2;

import java.util.Scanner;

public class OrdineBurger {
    public static void main(String[] args) {
        //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("===MENù===");
            System.out.println("1 - Ordina Burger");
            System.out.println("2 - Esci");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 2) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso 
                case 1:
                    //creo un oggetto hamburger base
                    BaseBurger hamburger = BaseBurger.getIstance("Classic Burger");
                    //ne stampo la descrizione
                    System.out.println(hamburger.getDescrizione());
                    //chiedo se di vuole aggiungere extra
                    System.out.println("Vuoi aggiungere extra?");
                    //opzioni
                    System.out.println("1 - SI");
                    System.out.println("2 - NO");
                    //prendo l'input di scelta e lo salvo nella variabile scelta
                    int risposta = myScannerInt.nextInt();
                    //verifico attraverso la risposta
                    if (risposta == 1) {
                        //creo la lista dell'ordine per gli extra
                        Ordine ordine = Ordine.getIstance();
                        //se ha scelto di aggiungere extra mostro le 
                        System.out.println("Cosa vuoi aggiungere?");
                        System.out.println("1 - Formaggio");
                        System.out.println("2 - Bacon");
                        System.out.println("3 - Entrambi");
                        //prendo l'input di scelta e lo salvo nella variabile scelta
                        int extra = myScannerInt.nextInt();
                        //in relazione alla risposta
                        if (extra == 1) {
                            //creo il decoratore extra formaggio
                            DecoratorCheese extraCheese = new DecoratorCheese(hamburger);
                            //lo aggiungo e ne stampo extra aggiunto
                            ordine.notifyObservers(extraCheese);
                            //riepilogo
                            ordine.riepilogo();
                        } else if (extra == 2) {
                            //creo il decoratore extra bacon
                            DecoratorBacon extraBacon = new DecoratorBacon(hamburger);
                            //lo aggiungo e ne stampo extra aggiunto
                            ordine.notifyObservers(extraBacon);
                            //riepilogo
                            ordine.riepilogo();
                        } else if (extra == 3) {
                            //creo il decoratore extra formaggio
                            DecoratorCheese extraCheese = new DecoratorCheese(hamburger);
                            //lo aggiungo e ne stampo extra aggiunto
                            ordine.notifyObservers(extraCheese);
                            //creo il decoratore extra bacon
                            DecoratorBacon extraBacon = new DecoratorBacon(hamburger);
                            //lo aggiungo e ne stampo extra aggiunto
                            ordine.notifyObservers(extraBacon);
                            //riepilogo
                            ordine.riepilogo();
                        }
                    //altrimenti do il riepilogo di ordine senza extra
                    } else {
                        System.out.println("Il prezzo totale è: " + hamburger.getPrezzo());
                    }
                    break;
                //nel caso di default
                default: 
                    //se la scelta è 2 stampo l'uscita
                    if (scelta == 2) {
                        System.out.println("Programma terminato!");
                    //altrimenti stampo l'errore
                    } else {
                        System.out.println("Errore: comando non valido, inserisci un comando valido:");
                    }
                    break;
            }
        } while (scelta != 2); //controllo lo stato della condizione
        //chiusura degli scanner
        myScannerInt.close();
    }
}
