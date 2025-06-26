import java.util.ArrayList;
import java.util.Collections;

public class ProvaArrayList {
    public static void main(String[] args) {
        //dichiaro un ArrayList
        ArrayList<Integer> numeri = new ArrayList<>();
        //aggiungo valori attraverso il metodo add all'interno dell'arraylist
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);

        //inserisco 10 valori casuali attraverso un ciclo for e il metodo add per aggiungere e random per avere il numero casuale 
        for (int i = 0; i < 10; i++) {
            numeri.add((int) (Math.random() * 100) + 1);
        }

        //stampo la lista originaria dei numeri
        System.out.println("Lista originale: " + numeri);

        //riordino l'array con il metodo sort
        Collections.sort(numeri);

        //stampo la lista ordinata
        System.out.println("Lista ordinata: " + numeri);

        //stampa la lunghezza dell'array
        System.out.println(numeri.size());
        //stampa dopo aver rimosso l'elemento dalla lista
        System.out.println(numeri.remove(0));
        //mi stampa l'indice del valore 
        System.out.println(numeri.indexOf(30));
        //stampa true se la lista è vuota e false se la lista è piena
        System.out.println(numeri.isEmpty());

        //Inverte l'array
        Collections.reverse(numeri);
        //Stampa l'array invertito
        System.out.println(numeri);
        
    }

}