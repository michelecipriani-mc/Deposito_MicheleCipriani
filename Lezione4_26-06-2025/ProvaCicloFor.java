import java.util.Scanner;

public class ProvaCicloFor {
    public static void main(String[] args) {

        //Inizializzo lo scanner
        Scanner scanner = new Scanner(System.in);

        //output guida
        System.out.println("Inserisci un numero:");
        //inizializzo variabile e assegno input inserito dall'utente
        int numero = scanner.nextInt();

        //Stampa la tabellina del numero inserito
        System.out.println("Tabellina del " + numero + ":");

        //ciclo for per effettuare la moltiplicazione e la stampa x numero
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero*i));
        }

        //chiusura scanner
        scanner.close();
    }
}