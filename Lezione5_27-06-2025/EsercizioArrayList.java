import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrayList {
    public static void main(String[] args) {
        //dichiarazione variabile
        String risposta;
        String elimina;
        int inseriti = 0;
        int eliminati = 0;
        //dichiarazione Arraylist
        ArrayList<String> studenti = new ArrayList<>();
        //dichiarazione Scanner
        Scanner myScanner = new Scanner(System.in);

        do {
            //Output guida
            System.out.println("Inserisci il nome dello studente: ");
            //attraverso il metodo add vado ad aggiungere direttamente il nome dello studente nell'arraylist
            studenti.add(myScanner.nextLine());
            inseriti++;

            //Output guida
            System.out.println("Vuoi inserire un nuovo studente? (Si/No)");
            //inserisco il valore in input nella variabile risposta
            risposta = myScanner.nextLine().toLowerCase().trim();

            //Verifico che la rispostra sia corretta
            while (!risposta.equals("si") && !risposta.equals("no")) {
                System.out.println("Inserisci un comando valido (Si/No)");
                risposta = myScanner.nextLine().toLowerCase().trim();
            }

        } while (risposta.equals("si")); //Verifico la condizione

        do {
            //Output guida
            System.out.println("Vuoi eliminare uno studente? (Si/No) ");
            //inserisco il valore in input nella variabile risposta
            elimina = myScanner.nextLine().toLowerCase().trim();

            //Verifico che la rispostra sia corretta
            while (!elimina.equals("si") && !elimina.equals("no")) {
                System.out.println("Inserisci un comando valido (Si/No)");
                elimina = myScanner.nextLine().toLowerCase().trim();
            }

            //se la risposta è si
            if (elimina.equals("si")) {
                //Output guida
                System.out.println("Inserisci il nome dello studente: ");
                //attraverso il metodo remove vado ad eliminare direttamente il nome dello studente nell'arraylist
                studenti.remove(myScanner.nextLine());
                eliminati++;

                //Output guida
                System.out.println("Vuoi eliminare altri studenti? (Si/No)");
                //inserisco il valore in input nella variabile risposta
                elimina = myScanner.nextLine().toLowerCase().trim();
            }
        } while (elimina.equals("si")); //Verifico la condizione

        //stampo il numero di studenti
        System.out.println("Sono stati inseriti: " + inseriti + "! Ne sono stati eliminati" + eliminati + "! L'elenco è composto da " + studenti.size() + " il suo ordine alfabetico è:");

        //ordino in ordine alfabetico
        Collections.sort(studenti);
        //stampo attraverso un foreach il nome di ogni studente
        for (String studente : studenti) {
            System.out.println(studente);            
        }

        //chiusura scanner
        myScanner.close();
    }
}