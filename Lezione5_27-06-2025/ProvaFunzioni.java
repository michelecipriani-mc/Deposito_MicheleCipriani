public class ProvaFunzioni {
    //creo una funzione senza parametri
    static void saluta() {
        System.out.println("Ciao, Java!");
    }

    static void mostra(int numero){
        System.out.println("Numero: " + (10 + numero));
    }

    static void mostra(String testo){
        System.out.println("Testo: " + testo);
    }

    //creo una funzione con parametro
    static int somma(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        saluta(); // Chiamata del metodo
        mostra(10); // Chiamata del metodo mostra int
        mostra("Ciao"); // Chiamata del metodo mostra string

        //richiamo e stampo la funzione somma
        System.out.println(somma(10, 20));
    }
}
