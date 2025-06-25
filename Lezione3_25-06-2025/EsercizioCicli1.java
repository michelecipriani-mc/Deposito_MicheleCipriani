import java.util.Scanner;

public class EsercizioCicli1 {
    public static void main(String[] args) {
        //Inizializzazione variabili
        int i = 3;
        final String passwordC = "java123";
        boolean accessoRiuscito = false;
        String risposta;
        
        //inizializzo scanner
        Scanner scanner = new Scanner(System.in);
        //primociclo while
        while (i > 0) {
            //output guida
            System.out.println("Inserisci password:");
            //Inserisco input nella variabile
            String password = scanner.nextLine();
            //verifico con un if se la password inserita corrisponde
            if (password.equals(passwordC)) {
                //se corretta comunico il cambio di stato e interrompo il ciclo
                accessoRiuscito = true;
                return;
            } else{
                //altrimenti comunico che la pass è errata e comunico i tentativi e confermo lo stato
               System.out.println("Password Errata! ti restano " + i + " tentativi");
               accessoRiuscito = false;
            }
            //diminuisco il valore della i per i tentativi
            i--;
        }

        //effettuo una verifica sull'accesso
        if (accessoRiuscito) {
            //effettuo un ciclo do-while per verificare la risposta dell'accesso
            do {
                //output guida
                System.out.println("Vuoi accedere al sistema? (S/N)");
                //Inserisco input nella variabile e la rendo tutta minuscola
                risposta = scanner.nextLine().toLowerCase();
            } while (risposta != "s" && risposta != "n");

            //condizione nel caso in cui la risposta sia si o no
            if (risposta.equals("s")) {
                System.out.println("Accesso effettuato!");
            } else {
                System.out.println("Accesso annullato!");
            }
        }else{
            //risposta in caso di accesso bloccato per superamneto tentativi
            System.out.println("Accesso bloccato!");
        }

        //chiusura scanner
        scanner.close();
    }

}
