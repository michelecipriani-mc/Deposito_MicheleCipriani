import java.util.Scanner;

public class ProvaWhile {
    public static void main(String[] args) {
        //dichiaro le variabili
        int i = 1;
        int numero;

        /* WHILE */
        //effttuo il ciclo while
        while (i <= 5) {
            i++; //incremento della variabile di controllo
            System.out.println(i); //Stampo la modifica di i
        }


        /* DO-WHILE */
        //Creo uno scanner per prendere in input un dato dall'utente
        Scanner scanner = new Scanner(System.in);
        //Ciclo do-While
        do {
            //output guida
            System.out.println("Inserisci un numero (0 per uscire): ");
            // inserisco il valore nella variabile
            numero = scanner.nextInt();
        } while (numero != 0);
        //stampo la fuoriuscita dal ciclo
        System.out.println("Hai inserito 0. Programma terminato.");
        
        //Chiudo lo scanner
        scanner.close();
    }
}
