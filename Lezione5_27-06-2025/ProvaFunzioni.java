//Creazione di una classe
class UtilitàMatematica {
    //creazione del metodo di una classe
    static int quadrato(int num) {
        return num * num;
    }

    //creazione del metodo di una classe
    int cubo(int num) {
        return num * num * num;
    }
}

public class ProvaFunzioni {
    //creo una funzione senza parametri
    static void saluta() {
        System.out.println("Ciao, Java!");
    }
    
    //creo una funzione con parametro
    static int somma(int a, int b) {
        return a + b;
    }

    static void mostra(int numero){
        System.out.println("Numero: " + (10 + numero));
    }

    static void mostra(String testo){
        System.out.println("Testo: " + testo);
    }

    static int fattoriale(int n){
        if (n == 1) {
            return 1;
        }
        return n*fattoriale(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        saluta(); // Chiamata del metodo
        mostra(10); // Chiamata del metodo mostra int
        mostra("Ciao"); // Chiamata del metodo mostra string

        //richiamo e stampo la funzione somma
        System.out.println(somma(10, 20));

        System.out.println("il fattoriale di " + n + " è: " + fattoriale(n));

        System.out.println(UtilitàMatematica.quadrato(5));

        UtilitàMatematica obj = new UtilitàMatematica();
        System.out.println(obj.cubo(5));
    }
}
