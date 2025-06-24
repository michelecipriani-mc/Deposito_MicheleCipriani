public class ProvaVariabili {
    public static void main(String[] args) {

        //Dichiaro e inizializzo variabili int
        int x = 12;
        int y = 23;
        int a = 1, b = 2, c = 3;
        int m, n;
        m = n = 50;

        //Dichiaro e inizializzo una costante
        final int z = 26;

        //Dichiaro e inizializzo le stringhe
        String saluto = "Ciao";
        String nome = "Michele";
        String salutoCompleto = saluto + nome;

        //Variabili booleane
        boolean provaFlsBool = false;
        boolean provaTreBool = true;

        //stampa variabili int
        System.out.println(x);
        System.out.println(y);
        System.out.println(x + y);
        System.out.println(a + b + c);
        System.out.println(m + n);
        System.out.println(z + " è una costante");

        //stampa le due stringhe
        System.out.println(saluto);
        System.out.println(nome);

        //Concatenazione delle stinghe
        System.out.println(saluto + " " + nome);
        System.out.println(salutoCompleto);

        //stampa Booleani
        System.out.println(provaFlsBool);
        System.out.println(provaTreBool);

    }
}
