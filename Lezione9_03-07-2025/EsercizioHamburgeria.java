import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHamburgeria {
    public static void main(String[] args) {
        //dichiaro l'arraylist di hamburger
        ArrayList<Hamburger> panini = new ArrayList<Hamburger>();
        //dichiaro l'arraylist di ingredienti necessari per il personal burger
        ArrayList<String> ingredienti = new ArrayList<>();
        //dichiarazione degli scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScannerStr = new Scanner(System.in);

        //variabile booleana per uscire dal ciclo
        boolean ordine = true;

        //inizio il ciclo
        while (ordine) {
            //inizializzo una scelta
            int scelta;
            //menù
            System.out.println("---MENU' HAMBURGER---");
            System.out.println("1 - Cheeseburger");
            System.out.println("2 - Vegan burger");
            System.out.println("3 - Double Bacon burger");
            System.out.println("4 - Panino personalizzato");
            System.out.println("5 - Termina ordine");

            //valorizzo la risposta
            scelta = myScanner.nextInt();

            switch (scelta) {
                //caso 1 creo un nuovo cheeseburger
                case 1:
                    Hamburger cheeseburger = new Cheeseburger("Cheeseburger");
                    //aggiungo panino alla lista
                    panini.add(cheeseburger);
                    break;
                //caso 2 creo un nuovo vegBurger
                case 2:
                    Hamburger veganBurger = new VegBurger("Vegan Burger");
                    panini.add(veganBurger);
                    break;
                //caso 3 creo un nuovo doubleBurger
                case 3:
                    Hamburger doubleBurger = new DoubleBacon("DoubleBacon Burger");
                    panini.add(doubleBurger);
                    break;
                //caso 4 creo un nuovo panino personalizzato
                case 4:
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Inserisci ingrediente: ");
                        //valorizzo la risposta
                        String ingrediente = myScannerStr.nextLine();
                        // aggiungo ingrediente alla lista
                        ingredienti.add(ingrediente);
                    }
                    Hamburger personal = new PersonalBurger("Personal Burger");
                    panini.add(personal);
                    break;
                //caso 2 esco dal menù
                case 5:
                    System.out.println("Ordine terminato!");
                    ordine = false;
                    break;
                //in caso di errore di scelta mi stampa scelta non valida
                default: System.out.println("Scelta non valida!");
                    break;
            }
        }

        //stampo l'ordine completo
        System.out.println("Il tuo ordine completo è: ");
        //con un foreach ciclo e stampo tutti i panini
        for (Hamburger hamburger : panini) {
            //se è creato come Cheeseburger richiamo il suo metodo stampa
            if (hamburger instanceof Cheeseburger) {
                hamburger.prepara();
            //altrimenti se è creato come vegburger richiamo il suo metodo stampa
            } else if (hamburger instanceof VegBurger) {
                hamburger.prepara();
            //altrimenti se è creato come doubleBacon richiamo il suo metodo stampa
            } else if (hamburger instanceof DoubleBacon) {
                hamburger.prepara();
            //altrimenti se è creato come personalBurger richiamo il suo metodo stampa
            } else if (hamburger instanceof PersonalBurger) {
                ((PersonalBurger)hamburger).prepara(ingredienti);
            //altrimenti stampo la funzione base di hamburger
            } else {
                hamburger.prepara();
            }
            //stampo una linea vuota aggiuntiva per separare le varie stampe
            System.out.println();
        }
        //chiusura scanner
        myScannerStr.close();
        myScanner.close();
    }
}
//classe padre hamburger
class Hamburger {
    //attributo protetto perchè classe padre
    protected String nome;
    //costruttore
    public Hamburger(String nome) {
        this.setNome(nome);
    }
    //getter
    public String getNome() {
        return nome;
    }
    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    //metodo di stampa preparazione
    public void prepara() {
        System.out.println("Il tuo panino è in preparazione!");
    }
}
//classe figlia che estende hamburger
class Cheeseburger extends Hamburger {
    //attributo privato prezzo
    private double prezzo;
    //costruttore
    public Cheeseburger(String nome) {
        super(nome);
        this.setPrezzo(3.99);
    }
    //getter
    public double getPrezzo() {
        return prezzo;
    }
    //setter
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override //override del metodo di stampa preparazione
    public void prepara() {
        super.prepara();
        System.out.println("Ti stiamo preparando un Cheeseburger, che è composto da\n- pane, formaggio, carne, Ketchup\n al costo di: " + this.getPrezzo());
    }
}
//classe figlia che estende hamburger
class VegBurger extends Hamburger {
    //attributo privato prezzo
    private double prezzo;
    //costruttore
    public VegBurger(String nome) {
        super(nome);
        this.setPrezzo(5.99);
    }
    //getter
    public double getPrezzo() {
        return prezzo;
    }
    //setter
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override //override del metodo di stampa preparazione
    public void prepara() {
        super.prepara();
        System.out.println("Ti stiamo preparando un Vegan Burger, che è composto da\n- pane integrale, insalata, Burger vegetale, pomodoro\n al costo di: " + this.getPrezzo());
    }
}
//classe figlia che estende hamburger
class DoubleBacon extends Hamburger {
    //attributo privato prezzo
    private double prezzo;
    //costruttore
    public DoubleBacon(String nome) {
        super(nome);
        this.setPrezzo(4.99);
    }
    //getter
    public double getPrezzo() {
        return prezzo;
    }
    //setter
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override //override del metodo di stampa preparazione
    public void prepara() {
        super.prepara();
        System.out.println("Ti stiamo preparando un Double Bacon, che è composto da\n- pane, bacon, doppia carne, cheddar, maionese\n al costo di: " + this.getPrezzo());
    }
}
//classe figlia che estende hamburger
class PersonalBurger extends Hamburger {
    //attributo privato prezzo
    private double prezzo;
    //costruttore
    public PersonalBurger(String nome) {
        super(nome);
        this.setPrezzo(8.99);
    }
    // getter
    public double getPrezzo() {
        return prezzo;
    }
    //setter
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //overloading del metodo prepara
    public void prepara(ArrayList<String> ingredienti) {
        System.out.println("Ti stiamo preparando un Personal Burger, che è composto da ");
        for (String ingrediente : ingredienti) {
            System.out.println("- " + ingrediente);
        }
        System.out.println("al costo di: " + this.getPrezzo());
    }

    
}
