package EsercizioInterfaccia1;

import java.util.ArrayList;
import java.util.Scanner;

public class ConseganaManager {
    public static void main(String[] args) {
        //dichiarazione ArrayList
        ArrayList<VeicoloConsegna> flottaConsegne = new ArrayList<>();

        //creo la flotta di veicoli
        flottaConsegne.add(new Furgone("AX125CY", 450));
        flottaConsegne.add(new Furgone("CE786JK", 300));
        flottaConsegne.add(new Drone("AA159BB", 50));
        flottaConsegne.add(new Drone("SE753QL", 100));

        //Dichiaro lo scanner
        Scanner myScannerStr = new Scanner(System.in);
        Scanner myScannerInt = new Scanner(System.in);
        //dichiaro un avariabile
        int scelta;

        do {
            
            
        } while (scelta != 4);




    }
}
