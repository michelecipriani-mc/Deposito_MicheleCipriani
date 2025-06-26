import java.util.Scanner;

public class EsercizioCicliFor1 {
    public static void main(String[] args) {
        //Inizializzazione variabile globale
        String continua;
        //Inizializzazione scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        //creo un ciclo do-while che mi permette di replicare il codice per altri studenti ma di partire da un primo
        do {
            //output guida
            System.out.println("Inserisci il nome alunno:");
            //inizializzazione variabile con allocazione input dell'utente al suo interno
            String nomeAlunno = scanner.nextLine();

            //inizializzo la variabile numro voti
            int nVoti;
            //output guida
            System.out.println("Quanti voti vuoi inserire?");
            //inizializzazione variabile con allocazione input dell'utente al suo interno
            nVoti = myScanner.nextInt();

            //Ciclo while di controllo per voti validi != da 0
            while (nVoti <= 0) {
                System.out.println("Inserisci un numero di voti valido: ");
                nVoti = myScanner.nextInt();
                myScanner.nextLine();
            }

            //output 
            System.out.println("Perfetto inserisci i tuoi voti! ");

            //Inizializzazione variabile a 0 per la somma dei voti necessaria per la media
            int sommaVoti = 0;

            //Ciclo for per richiesta singolo voto
            for (int i = 1; i <= nVoti; i++) {
                int voto;
                System.out.println("Inserisci il "+ i +"° voto: ");
                voto = myScanner.nextInt();

                //verifico con un while che il voto sia valido in un range da 0 a 30
                while (voto < 0 || voto > 30) {
                    System.out.println("Inserisci un voto valido: ");
                    voto = myScanner.nextInt();
                }

                // //condizione di verifica per stampare la tipologia di voto 
                // if (voto >= 18 && voto <= 24) {
                //     System.out.println("Sufficiente");
                // } else if (voto >= 24 && voto <= 29) {
                //     System.out.println("Buono");
                // } else if (voto == 30) {
                //     System.out.println("Ottimo");
                // } else {
                //     System.out.println("Insufficiente");
                // }

                //effettuo la somma dei voti nella variabile dichiarata in precedenza
                sommaVoti += voto;
            }

            //calcolo della media
            double media = (double) sommaVoti / nVoti;

            //Stampa nome alunno e media
            System.out.print("La media voti di " + nomeAlunno + " è di: " + media);

            //condizione di verifica per stampare la tipologia di media
            if (media >= 18 && media <= 24) {
                System.out.println(" Sufficiente");
            } else if (media >= 24 && media <= 28) {
                System.out.println(" Buono");
            } else if (media >= 29) {
                System.out.println(" Ottimo");
            } else {
                System.out.println(" Insufficiente");
            }


            //richiedo se si vuole inserire voti per un nuovo alunno
            System.out.print("Vuoi inserire i voti di un altro studente? (Si/No): ");
            //inizializzazione variabile con allocazione input dell'utente al suo interno
            continua = scanner.nextLine().toLowerCase();
        } while (continua.equals("si")); //verifico la condizione 

        //Messaggio di fuoriuscita dal ciclo
        System.out.println("Programma terminato.");
        //chiusura scanner
        scanner.close();
        myScanner.close();
    }
}
