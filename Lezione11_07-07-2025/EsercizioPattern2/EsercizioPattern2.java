package EsercizioPattern2;

import java.util.Scanner;

public class EsercizioPattern2 {
    public static void main(String[] args) {
        //creo la prima istanza
        DatabaseManager primoDB = DatabaseManager.getIstance();
        //richiamo il metodo
        primoDB.connect();

        //creo la seconda istanza
        DatabaseManager secondoDB = DatabaseManager.getIstance();
        //richiamo il metodo
        secondoDB.connect();

        //creo la terza istanza
        DatabaseManager terzoDB = DatabaseManager.getIstance();
        //richiamo il metodo
        terzoDB.connect();
        //controllo che le istanze siano tutte uguali
        if (primoDB.equals(secondoDB) && secondoDB.equals(terzoDB)) {
            System.out.println("Tutte le variabili si riferiscono alla stessa istanza!");
        } else {
            System.out.println("Errore: le variabili non si riferiscono alla stessa istanza");
        }
        //stampo il numero totale di connessioni
        System.out.println("Numero totale di connessioni: " + primoDB.getConnectionCount());

        //inizializzo uno scanner
        Scanner myScanner = new Scanner(System.in);
        //creo una variabile booleana per l'iterazione del ciclo
        boolean itera = true;
        //ciclo per la gestione delle scelte
        while (itera) {
            //menù
            System.out.println("1 - Connettiti al DB");
            System.out.println("2 - Resetta connessione al DB");
            System.out.println("3 - Stampa numero di connessioni");
            System.out.println("4 - Esci");
            //inizializzo la variabile scelta con l'input dell'utente
            int scelta = myScanner.nextInt(); 
            //switch per gestire la scelta
            switch (scelta) {
                //nel primo caso mi connetto al db
                case 1:
                    //creo una nuova istanza
                    DatabaseManager connessione = DatabaseManager.getIstance();
                    //creo un anuova connessione
                    connessione.connect();
                    break;
                //nel secondo caso mi disconnetto dal db
                case 2:
                    //resetto le connessioni
                    DatabaseManager.resetInstance();
                    break;
                //nel terzo caso stampo tutte le connessioni
                case 3:
                    //screo l'istanza per richiamare il metodo
                    DatabaseManager manager = DatabaseManager.getIstance();
                    //stampo il numero totale di connessioni
                    System.out.println("Numero totale di connessioni: " + manager.getConnectionCount());
                    break;
                //nel quarto caso esco dal programma
                case 4:
                    //messaggio di uscita
                    System.out.println("Programma Terminato");
                    itera = false;
                    break;
                default: System.out.println("Scelta non valida"); //messaggio di default
                    break;
            }
        }
        //chiusura scanner
        myScanner.close();
    }
}
