import java.util.Scanner;

public class EsercizioCondizioni1 {
    public static void main(String[] args) {
        //Creo lo scanner per i numeri
        Scanner myNumScanner = new Scanner(System.in);
        //Output guida
        System.out.println("Inserisci la tua età:");
        //salvo il valore in una variabile
        int age = myNumScanner.nextInt();

        //Creo uno scanner per le stringhe
        Scanner myScanner = new Scanner(System.in);

        //Output guida
        System.out.println("Hai un biglietto valido?");
        //salvo il valore in una variabile e rendo tutto minuscolo
        String ticket = myScanner.nextLine().toLowerCase();

        //Output guida
        System.out.println("Viaggi accompagnato da un adulto?");
        //salvo il valore in una variabile e rendo tutto minuscolo
        String companion = myScanner.nextLine().toLowerCase();

        //Output guida
        System.out.println("Hai acquistato un salta fila?");
        //salvo il valore in una variabile e rendo tutto minuscolo
        String skip = myScanner.nextLine().toLowerCase();

        //Condizioni 
        if (age > 18 && ticket.equals("si") && skip.equals("si")) {
            System.out.println("Prego salti la fila e salga a bordo");
        } else if (age < 18 && companion.equals("si") && ticket.equals("si") && skip.equals("si")) {
            System.out.println("Prego salti la fila e salga a bordo");
        } else if (age < 18 && companion.equals("si") && ticket.equals("si") && skip.equals("no")) {
            System.out.println("Al suo turno può salire a bordo");
        } else if (age > 18 && ticket.equals("si") && skip.equals("no")) {
            System.out.println("Al suo turno può salire a bordo");
        } else if (age < 18 && companion.equals("no")) {
            System.out.println("Mi dispiace è troppo piccolo per viaggiare solo deve essere accompagnato da un adulto");
        } else {
            System.out.println("Mi dispiace deve avere un biglietto valido");
        }

        //Chiusura Scanner
        myScanner.close();
        myNumScanner.close();
    }
}
