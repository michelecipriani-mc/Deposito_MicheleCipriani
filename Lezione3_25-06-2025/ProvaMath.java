public class ProvaMath {
    public static void main(String[] args) {
        //Inizializzo le variabili
        int x = 5;
        int y = 10;
        int randomNum;

        /*Provo a stampare le funzioni math applicate alle variabili x e y*/
        //MAssimo
        System.out.println(Math.max(x, y));
        //Minimo
        System.out.println(Math.min(x, y));
        //Radice quadrata
        System.out.println(Math.sqrt(y));
        // valore assoluto di un numero
        System.out.println(Math.abs(x));
        //Randomizzatore tra 0 e 1 di defoult
        System.out.println(Math.random());

        //eseguo una randomizzazione da 0 a 100
        randomNum = (int)(Math.random() * 101);
        //Stampo questo numero random da 0 a 100
        System.out.println(randomNum);
    }
}
