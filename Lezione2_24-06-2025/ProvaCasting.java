import java.util.Scanner;

public class ProvaCasting {
    public static void main(String[] args) {

        /*CASTING */

        //Inizializzo una varibile intera
        int myInt = 10;

        //Inizializzo una variabile double ed effettuo un custing automatico da int a double
        double myDouble = myInt;

        //Stampo le due variabili
        System.out.println(myInt);
        System.out.println(myDouble);

        //Inizializzo una variabile double
        double myDouble1 = 9.78d;

        //Inizializzo una varibile intera ed effettuo un custing esplicito da double a int
        int myInt1 = (int) myDouble1;

        //Stampo le due variabili
        System.out.println(myDouble1);
        System.out.println(myInt1);

        /*SCANNER */

        //Creo un oggetto di tipo scanner
        Scanner myObj = new Scanner(System.in);
        //Output guida all'utente
        System.out.println("Enter username: ");

        //inizializzo la stringa dell'oggeto Scanner con l'input inserito dall'utente nella linea successiva
        String userName = myObj.nextLine();
        //stampo il nome inserito dall'utente
        System.out.println("Username is: " + userName);

        myObj.close();
    }
}
