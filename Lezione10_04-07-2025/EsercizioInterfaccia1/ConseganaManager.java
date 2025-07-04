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
            //menù
            System.out.println("===MENU'===");
            System.out.println("1 - Aggiungi veicolo");
            System.out.println("2 - Chiedi Consegna");
            System.out.println("3 - Traccia Consegna");
            System.out.println("4 - Esci");
            //valorizzo la scelta
            scelta = myScannerInt.nextInt();
            //switch per i casi del menù
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci targa: ");
                    //valorizzo l'input'
                    String targa = myScannerStr.nextLine();
                    System.out.println("Inserisci carico massimo: ");
                    //valorizzo l'input'
                    float carico = myScannerInt.nextInt();
                    //richiedo il tipo di veicolo
                    System.out.println("Tipo di veicolo? (Furgone o Drone) ");
                    //valorizzo l'input'
                    String risposta = myScannerStr.nextLine().toLowerCase();
                    //se è drone
                    if (risposta.equals("drone")) {
                        Drone drone = new Drone(targa, carico);
                        flottaConsegne.add(drone);
                        System.out.println("Drone registrato correttamente!");
                    //se è furgone
                    } else if (risposta.equals("furgone")){
                        Furgone furgone = new Furgone(targa, carico);
                        flottaConsegne.add(furgone);
                        System.out.println("Furgone registrato correttamente!");
                    }
                    break;
                case 2:
                    //richiedo il tipo di veicolo
                    System.out.println("Tipo di veicolo? (Furgone o Drone) ");
                    //valorizzo l'input'
                    String veicolo = myScannerStr.nextLine().toLowerCase();
                    
                default: System.out.println("Scelta errata!");
                    break;
            }
            
        } while (scelta != 4);




    }
}
