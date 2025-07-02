package Esercizio;

public class Controller {
    //creo un metodo che verifica che il numero fornito sia positivo
    public static void checkPositive(int x) throws NumeroNegativoException {
        //se il numero e minore di 0
        if (x < 0) {
            //creo una nuova eccezione
            throw new NumeroNegativoException("Errore: numero negativo!", null);
        }
    }

    //creo un metodo che verifica che il numero fornito sia diverso da 0
    public static void checkNotZero(int x) throws NumeroZeroException {
        //se x è 0
        if (x == 0) {
            //creo una nuova eccezione
            throw new NumeroZeroException("Errore: Devi inserire un numero diverso da 0", null);
        }
    }
}
