public class ProvaOperatori {
    public static void main(String[] args) {
        //Inizializzo variabili
        int x = 10;
        int y = 10;
        //la stampo
        System.out.println(x);
        //sommo ad x 
        x += 5;
        //stampo il valore aggiornato
        System.out.println(x);

        /*OPERATORI ARRITMETICI*/
        
        //Operatore somma
        System.out.println(x + y);
        //Operatore sottrazione
        System.out.println(x - y);
        //Operatore moltiplicazione
        System.out.println(x * y);
        //Operatore divisione
        System.out.println(x / y);
        //Operatore modulo
        System.out.println(x % 2);
        System.out.println(y % 2);

        /*OPERATORE DI CONFRONTO*/
        //Operatore maggiore
        System.out.println(x > y);
        //Operatore minore
        System.out.println(x < y);
        //Operatore maggiore uguale
        System.out.println(x >= y);
        //Operatore minore uguale
        System.out.println(x <= y);
        //Operatore di uguaglianza
        System.out.println(x == y);
        //Operatore diverso
        System.out.println(y != x);

        /*OPERATORI LOGICI*/
        //Operatore AND
        System.out.println(x > y && x != y);
        //Operatore OR
        System.out.println(x < y || x > y);
        //Operatore NOT
        System.out.println(!(x > y && x != y));
        System.out.println(!(x > y || x != y));

    }
}
