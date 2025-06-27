import java.util.Scanner;

public class EsercizioFunzioni1 {
    //Creo la funzione che preso un parametro n calcoli il suo fattoriale
    static long calcoloFattoriale(int n){
        long risultatoFattoriale = 1;
        for (int i = 2; i <= n; i++) {
            risultatoFattoriale *= i;
        }
        return risultatoFattoriale;
    }

    //creo la verisone overloadata con String
    static void calcoloFattoriale(String string){
        System.out.println("Numero non valido!");
    }
    
    public static void main(String[] args) {
        //creo uno scanner
        Scanner myScanner = new Scanner(System.in);

        //Output guida
        System.out.println("Inserisci un numero intero: ");

        //utilizzo il try catch per gestire l'eccezione
        try {
            int input = myScanner.nextInt();
            long risultato = calcoloFattoriale(input);
            System.out.println("il fattoriale di " + input +" è: "+ risultato);
        } catch (Exception e) {
            calcoloFattoriale("errore");
        }

        //chiudo lo scanner
        myScanner.close();
    }
}
