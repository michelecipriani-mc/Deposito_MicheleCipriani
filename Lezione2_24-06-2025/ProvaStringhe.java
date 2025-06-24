import java.util.Arrays;

public class ProvaStringhe {
    public static void main(String[] args) {

        //creo una variabile stringa
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String frase = "Please locate where 'locate' occurs!";
        String a = "10";
        String b = "20";

        //creo variabili intere
        int x = 10, y = 20;
        //Length, lunghezza della stringa
        int length = txt.length();

        /*METODI DELLE STRINGHE */
        //applico il metodo length
        System.out.println("The length is: " + txt.length());
        //applico il metodo toLowerCase
        System.out.println("The length is: " + txt.toLowerCase());
        //applico il metodo toUpperCase
        System.out.println("The length is: " + txt.toUpperCase());
        //applico il metodo indexOf
        System.out.println(frase.indexOf("locate"));
        //applico il metodo indexOf
        System.out.println(frase.concat(txt));
        //metodo equals
        System.out.println(a.equals(b));
        //metodo contains
        System.out.println(a.contains("1"));
        //metodo isEmpty
        System.out.println(a.isEmpty());

        //somma tra 2 numeri
        System.out.println(x + y);
        //Somma tra 2 stringhe
        System.out.println(a + b);
        //Somma tra una stringa ed un intero
        System.out.println(x + a);

        /* CARATTERI SPECIALI */
        //Single quote
        System.out.println("\\Ciao\\");
        //Double quote
        System.out.println("\"Ciao\"");
        //Backslash
        System.out.println("\'Ciao\'");
        //New Line
        System.out.println("Ciao\n 1");
        //Carriage Return
        System.out.println("Ciao\r 2");
        //Tab
        System.out.println("Ciao\t 3");
        //Backspace
        System.out.println("Ciao\b 4");
        //Form Feed
        System.out.println("Ciao\f 5");

        //metodo split
        String[] words = frase.split("\\s"); // "\\s == spazio"
        System.out.println(Arrays.toString(words));

        //stampo il valore length che sarà del numero di caratteri presenti in txt
        System.out.println("Lunghezza: " + length);



    }
}
