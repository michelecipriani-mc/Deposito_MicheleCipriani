import java.util.Scanner;

public class EserciziFunzioni {
    //creazione metodo somma numeri
    static int sommaNumeri(int x, int y) {
        return x + y;
    }

    //creazione metodo moltiplica interi
    static int multiply(int x, int y) {
        return x * y;
    }
    
    //creazione metodo moltiplica double
    static double multiply(double x, double y, double z) {
        return x * y * z;
    }

    //creazione metodo somma interi
    static int sommaInteri(int n) {
        int sommaTotale = 0;
        if (n != 0) {
            return sommaTotale = n + sommaInteri(n - 1);   
        } else {
            return sommaTotale;
        }
    }

    //metodo per modificare una variabile primitiva
    static void modificaValore(int x, int y) {
        x = x + y;
        System.out.println("Valore aggiornato: " + x);
    }

    //metodo per modificare un array
    static void moddificaArray(int[] array, int modifica) {
        System.out.println("Valore aggiornato: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + modifica;
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        //Inizializzazione variabile
        int scelta;
        int x, y = 0;
        double a, b, z = 0;
        //dichiarazione scanner
        Scanner myScanner = new Scanner(System.in);

        //messaggio di benvenuto
        System.out.println("Benvenuto, sei nel menu, queste sono le operazioni disponibili!");
        //ciclo che mi permette di farci vedere il menù ed effettuare le varie scelte
        do {
            System.out.println("Scegli operazione:\n1-Somma numeri\n2-Moltiplica iteri\n3-Moltiplica numeri in virgola mobile\n4-Somma interi\n5-Modifica per Valore\n6-Modifica per Riferimento\n7-Esci dal menu");
            scelta = myScanner.nextInt();
            //verifichiamo attraverso un while che la scelta sia corretta
            while (scelta <=0 && scelta > 7) {
                System.out.println("Errore: Inserisci un numero valido per il menu: ");
                scelta = myScanner.nextInt();
            }

            //switch per permettermi di gestire cosa fa il menù
            switch (scelta) {
                //caso somma numeri
                case 1:
                    System.out.println("Inserisci il primo valore per la somma: ");
                    x = myScanner.nextInt();
                    System.out.println("Inserisci il secondo valore per la somma: ");
                    y = myScanner.nextInt();
                    System.out.println("La somma è: " + sommaNumeri(x, y));
                    break;
                //caso moltiplicazione numeri interi
                case 2:
                    System.out.println("Inserisci il primo valore per la moltiplicazione: ");
                    x = myScanner.nextInt();
                    System.out.println("Inserisci il secondo valore per la moltiplicazione: ");
                    y = myScanner.nextInt();
                    System.out.println("La moltiplicazione è: " + multiply(x, y));
                    break;
                //caso moltiplicazione double
                case 3:
                    System.out.println("Inserisci il primo valore per la moltiplicazione: ");
                    a = myScanner.nextDouble();
                    System.out.println("Inserisci il secondo valore per la moltiplicazione: ");
                    b = myScanner.nextDouble();
                    System.out.println("Inserisci il terzo valore per la moltiplicazione: ");
                    z = myScanner.nextDouble();
                    System.out.println("La moltiplicazione è: " + multiply(a, b, z));
                    break;
                //caso somma interi
                case 4:
                    System.out.println("Inserisci il valore intero da cui vuoi partire per la somma: ");
                    x = myScanner.nextInt();
                    System.out.println("La somma dei numeri interi partendo dal valore " + x + " a ritroso è: " + sommaInteri(x));
                    break;
                //modifica per valore
                case 5:
                    System.out.println("Modifica variabile per valore, inserisci il valore: ");
                    int valore = myScanner.nextInt();
                    System.out.println("di quanto vuoi modificarlo?");
                    int modifica = myScanner.nextInt();
                    System.out.println("Numero pre modifica: " + valore);
                    modificaValore(valore, modifica);
                    break;
                //modifica per riferimento
                case 6:
                    System.out.println("Modifica variabile per riferimento, inserisci lunghezza array: ");
                    int[] array = new int[myScanner.nextInt()];
                    System.out.println("di quanto vuoi modificarlo?");
                    int modificaArray = myScanner.nextInt();
                    for (int i = 0; i < array.length; i++) {
                        System.out.println("Inserisci il "+ i + "° valore dell'array: ");
                        array[i] = myScanner.nextInt();
                    }
                    System.out.println("Array prima della modifica:");
                    for (int i = 0; i < array.length; i++) {
                        System.out.println(array[i]);
                    }
                    moddificaArray(array, modificaArray);
                    break;
                //uscita dal programma
                case 7:
                    System.out.println("Grazie per aver usato il programma. Arrivederci!");
                    break;
                default:
                    break;
            }
            
        } while (scelta != 7); //verifica della condizione nel while

        //output di uscita dal menù
        System.out.println("Programma terminato! Arrivederci");

        //chiusura dello scanner
        myScanner.close();
    }
}
