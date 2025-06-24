import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {

        //Creo un oggetto di tipo scanner
        Scanner myScanner = new Scanner(System.in);
        //Output guida all'utente
        System.out.println("Inserisci una stringa: ");
        //inizializzo la stringa dell'oggeto Scanner con l'input inserito dall'utente nella linea successiva
        String stringa = myScanner.nextLine();
        //stampo la stringa inserita dall'utente
        System.out.println("La stringa inserita è: " + stringa);

        //Output guida all'utente
        System.out.println("inserisci un valore booleano (true/false):");
        //inizializzo il valore booleano dell'oggeto Scanner con l'input inserito dall'utente nella linea successiva
        boolean booleano = myScanner.nextBoolean();
        //stampo il valore booleano inserita dall'utente
        System.out.println("Il valore Booleano inserito è: " + booleano);

        //Creo un oggetto di tipo scanner
        Scanner myNumScanner = new Scanner(System.in);
        //output guida all'utente
        System.out.println("inserisci un valore intero:");

        //inizializzo il valore intero dell'oggeto Scanner con l'input inserito dall'utente nella linea successiva
        int intero = myNumScanner.nextInt();
        //stampo lil valore intero inserito dall'utente
        System.out.println("L'intero inserito è: " + intero);

        //casting da int a double
        double numDouble = intero;
        System.out.println("L'intero convertito in double: "+ numDouble);

        //output guida all'utente
        System.out.println("inserisci un valore float (con virgola mobile):");

        //inizializzo il valore float dell'oggeto Scanner con l'input inserito dall'utente nella linea successiva
        float numFloat = myNumScanner.nextFloat();
        //stampo lil valore intero inserito dall'utente
        System.out.println("Il numero in Virgola mobile inserito è: " + numFloat);

        //output guida all'utente
        System.out.println("inserisci un valore double (con virgola mobile):");

        //inizializzo il valore double dell'oggeto Scanner con l'input inserito dall'utente nella linea successiva
        double numDouble1 = myNumScanner.nextDouble();
        //stampo lil valore double inserito dall'utente
        System.out.println("Il numero in Virgola mobile inserito è: " + numDouble1);

        //casting da double a int
        int numInt = (int) numDouble1;
        System.out.println("L'intero convertito in int: "+ numInt);

        //chiusura dello scanner
        myNumScanner.close();
        myScanner.close();

    }
}
