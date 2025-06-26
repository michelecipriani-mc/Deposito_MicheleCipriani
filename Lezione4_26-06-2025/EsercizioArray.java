import java.util.Scanner;

public class EsercizioArray {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner myNumScanner = new Scanner(System.in);
        Scanner myStrScanner = new Scanner(System.in);

        //Inizializzo una variabile che mi permette di dare la lunghezza degli array
        int numDolci = 0;

        //Output guida
        System.out.println("Quanti tipi di dolci vuole ordinare?");
        //salvo il valore nella variabile
        numDolci = myNumScanner.nextInt();

        //eseguo un controllo per il valore negativo o pari a zero con un ciclo while
        while (numDolci <= 0 || numDolci > 10) {
            System.out.println("Inserisci un numero di dolci valido:");
            numDolci = myNumScanner.nextInt();
            myNumScanner.nextLine();
        }

        //dichiaro gli array e una variabile di appoggio per il conteggio totale
        String[] dolci = new String[numDolci];
        int[] quantità = new int[numDolci];
        int quantitàTotale = 0;

        //ciclo for per chiedere le tipologie di dolce
        for (int i = 0; i < dolci.length; i++) {
            System.out.println("Che tipo di dolce vuole?");
            dolci[i] = myStrScanner.nextLine();
        }

        //ciclo for per le quantità di singolo dolce
        for (int i = 0; i < quantità.length; i++) {
            System.out.println("Quale quantità di " + dolci[i] + "?");
            quantità[i] = myNumScanner.nextInt();
            //eseguo un controllo per il valore negativo o pari a zero con un ciclo while
            while (quantità[i] <= 0) {
                System.out.println("Inserisci una quantità valida:");
                quantità[i] = myNumScanner.nextInt();
                myNumScanner.nextLine();
            }
            //sommo tutte le quantita
            quantitàTotale += quantità[i];
        }

        //Stampo tutto l'ordine con un ciclo for 
        System.out.println("Hai ordinato: ");
        for (int i = 0; i < numDolci; i++) {
            System.out.println(quantità[i] + " pezzi di " + dolci[i]);
        }

        //stampo i pezzi totali ordinati
        System.out.println("Per un totale di " + quantitàTotale + " pezzi.");

        //chiudo gli scanner
        myStrScanner.close();
        myNumScanner.close();
    }
}
