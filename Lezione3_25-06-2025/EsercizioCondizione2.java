import java.util.Scanner;

public class EsercizioCondizione2 {
    public static void main(String[] args) {
        //inizializzazione variabili
        final double bPolicy = 500.00;
        double finPrice = bPolicy;
        String pack;
        boolean fitDrive = true;

        //Creo lo scanner per i numeri
        Scanner myNumScanner = new Scanner(System.in);

        /*ETA'*/

        //Output guida
        System.out.println("Inserisci la tua età:");
        //salvo il valore in una variabile
        int age = myNumScanner.nextInt();

        //Verifico se il valore inserito è diverso da 0
        if (age <= 0) {
            //Output guida
            System.out.println("Inserisci un età valida:");
            //salvo il valore in una variabile
            age = myNumScanner.nextInt();
            myNumScanner.nextLine();
        }

        //Verifica dell'età
        if (age < 18) {
            fitDrive = false;
        } else if (age <= 25) {
            finPrice *= 1.20;
        } else if (age > 50) {
            finPrice *= 0.90;
        }

        /*ESPERIENZA ALLA GUIDA*/

        //Output guida
        System.out.println("Quanti anni di esperienza hai alla guida?");
        //salvo il valore in una variabile
        int yearDrEx = myNumScanner.nextInt();

        //verifica per gli anni di esperienza
        if (yearDrEx < 2) {
            finPrice *= 1.30;
        }

        //Output guida
        System.out.println("Quanti incidenti hai fatto negli ultimi 5 anni?");
        //salvo il valore in una variabile
        int drInc = myNumScanner.nextInt();

        //verifica in relazione agli incidenti
        if (drInc < 4) {
            if (drInc == 1) {
                finPrice *= 1.15;               
            } else if (drInc >= 2) {
                finPrice *= 1.30;
            }
        } else {
            fitDrive = false;
        }

        if (fitDrive) {
            //Stampa preventivo finale
            System.out.printf("Possiamo procedere con la configurazione del pacchetto");
        } else {
            System.out.println("Non sei idoneo per l'assicurazione");
        }


        //inizilaizzo lo scanner per le stringhe
        Scanner myScanner = new Scanner(System.in);
        //output guida
        System.out.println("Scegli il pacchetto assicurativo:");
        //salvo il valore in una variabile
        pack = myScanner.nextLine().toLowerCase();
        
        //switch per la scelta del pacchetto
        switch (pack) {
            case "base":
                //nessun cambiamento
                break;
            case "intermedio":
                finPrice *= 1.20;
                break;
            case "premium":
                finPrice *= 1.50;
                break;
            default: System.out.println("Scelta non valida, verrà applicato il pacchetto di Base");
                break;
        }

        System.out.printf("Il preventivo finale per l'assicurazione è: " + finPrice);
        
        //Chiusura degli scanner
        myScanner.close();
        myNumScanner.close();
    }
}
