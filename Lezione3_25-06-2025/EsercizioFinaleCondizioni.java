import java.util.Scanner;

public class EsercizioFinaleCondizioni {
    public static void main(String[] args) {
        //inizializzazione variabili
        boolean etàValida, garaValida, tempoValido, bmiValido;
        double tempo = 0;

        //Creo lo scanner per i numeri
        Scanner myNumScanner = new Scanner(System.in);
        Scanner myScanner = new Scanner(System.in);

        /*ETA'*/

        //Output guida
        System.out.println("Inserisci la tua età:");
        //salvo il valore in una variabile
        int età = myNumScanner.nextInt();

        //Verifico se il valore inserito è diverso da 0
        while (età <= 0) {
            //Output guida
            System.out.println("Inserisci un età valida:");
            //salvo il valore in una variabile
            età = myNumScanner.nextInt();
            myNumScanner.nextLine();
        }

        /*GARA*/

        //Output guida
        System.out.println("Hai mai corso una gara di 100mt? (Si/No)");
        //salvo il valore in una variabile
        String gare = myScanner.nextLine().toLowerCase();

        /*TEMPO*/
        //Controllo se il partecipante ha mai gareggiato
        if (gare.equals("si")) {
            garaValida = true;
            //Output guida
            System.out.println("Inserisci il miglior tempo registrato:");
            //salvo il valore in una variabile
            tempo = myNumScanner.nextDouble();
        } else {
            garaValida = false;
            System.out.println("Ci dispiace! Non può partecipare...");
        }
        
        /*ALTEZZA*/

        //Output guida
        System.out.println("Inserire la propria altezza:");
        //salvo il valore in una variabile
        double altezza = myNumScanner.nextDouble();

        /*PESO*/

        //Output guida
        System.out.println("Inserire il proprio peso:");
        //salvo il valore in una variabile
        double peso = myNumScanner.nextDouble();

        /*CALCOLO BMI */

        //calcolo BMI
        double bmi = peso / Math.pow(altezza, 2);

        //Controllo Età
        if (età >= 18 && età <= 40) {
            etàValida = true;
        } else{
            etàValida = false;
        }

        //Controllo Tempo
        if (garaValida && tempo < 12) {
            tempoValido = true;
        } else{
            tempoValido = false;
        }

        //Controllo BMI
        if (bmi < 25) {
            bmiValido = true;
        } else{
            bmiValido = false;
        }

        //Verifica se sei ammesso o non ammesso
        if (bmiValido && etàValida && tempoValido) {
            int numero = (int)(Math.random() * 1001);
            System.out.println("Complimenti! Sei stato ammesso alla gara con il numero " + numero);
        } else {
            System.out.println("Ci dispiace, i suoi requisiti non soddisfano i criteri! Non è ammeso alla gara");
        }

        //chiusura scanner
        myScanner.close();
        myNumScanner.close();
    }
}
