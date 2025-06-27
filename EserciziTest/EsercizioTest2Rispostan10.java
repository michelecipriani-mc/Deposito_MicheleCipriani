import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioTest2Rispostan10 {
    public static void main(String[] args) {
        //variabile
        String risposta;
        //dichiarazione scanner
        Scanner scanner = new Scanner(System.in);
        //ArrayList
        ArrayList<String> listaSpesa = new ArrayList<>();
        //ciclo per inserimento della spesa
        do {
            System.out.println("Inserisci elemento alla lista della spesa(fine per terminare):");
            risposta = scanner.nextLine().trim().toLowerCase(); 

            if (!risposta.equals("fine") && !risposta.isEmpty()) {
                listaSpesa.add(risposta);
            }

        } while (!risposta.equals("fine"));

        

        //stampa lista spesa
        System.out.println("Lista della spesa: ");
        for (String spesa : listaSpesa) {
            System.out.println("- " + spesa);
        }

        // Stampa il numero totale di elementi
        System.out.println("\nNumero totale di elementi: " + listaSpesa.size());

        // Controlla se contiene sia pane che latte
        if (listaSpesa.contains("pane") && listaSpesa.contains("latte")) {
            System.out.println("Hai pensato alla colazione!");
        }
        scanner.close();
    }
}
