public class ProvaSingleton {
    public static void main(String[] args) {
        //creo un nuovo oggetto Singletone
        Singleton istance = Singleton.getInstance();
        //richiamo la funzione
        istance.DoSomething();
    }
    
}

class Singleton {
    // Istanza privata statica della classe Singleton
    private static Singleton instance;
    // Costruttore privato per impedire l'istanziazione diretta
    private Singleton() {}
    // Metodo pubblico statico per ottenere l'unica istanza della classe
    public static Singleton getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
        instance = new Singleton();
        }
        // Restituisce l'istanza esistente o appena creata
        return instance;
    }
    // Metodo di esempio che può essere chiamato sull'istanza Singleton
    public void DoSomething() {
        System.out.println("Singleton: DoSomething() called");
    }
}