package EsercizioPattern2;

public class DatabaseManager {
    // Istanza privata statica della classe
    private static DatabaseManager istanza;
    //variabile contatore inizializzata
    private int connectionCount = 0;
    //costruttore
    private DatabaseManager() {}

    //metodo per ottenere sempre la stessa istanza
    public static DatabaseManager getIstance() {
        //se l'istanza è uguale a null
        if (istanza == null) {
            //la creo
            istanza = new DatabaseManager(); 
        }
        //restituisco l'istanza
        return istanza;
    }

    //Simula la connessione al DB
    public void connect() {
        connectionCount++;
        System.out.println("Connessione stabilita! Ci sono " + connectionCount + " connessioni attive.");
    }

    //getter per vedere le connessioni totali effettuate
    public int getConnectionCount() {
        return connectionCount;
    }  
    
    //metodo per bruciare l'istanza
    public static void resetInstance() {
        istanza = null;
        System.out.println("Database resettato!");
    }
}
