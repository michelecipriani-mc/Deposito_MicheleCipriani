import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioEreditarietà {
    public static void main(String[] args) {
        //dichiaro gli scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScannerInt = new Scanner(System.in);

        //dichiaro variabili
        int risposta;
        int contatore = 1;
        //dichiaro un oggetto zoo
        Zoo zoo = new Zoo();
        //output guida
        System.out.println("Inserisci tre animali: ");
        do {
            //menu
            System.out.println("1 - Cani: ");
            System.out.println("2 - Gatti: ");
            //valorizzo risposta
            risposta = myScannerInt.nextInt();

            //se la scelta è 1
            if (risposta == 1) {
                //chiedo dati per la creazione
                System.out.println("Inserisci nome: ");
                String nome = myScanner.nextLine();
                System.out.println("Inserisci età: ");
                int età = myScannerInt.nextInt();
                System.out.println("Inserisci razza: ");
                String razza = myScanner.nextLine();
                //creo oggetto cane
                Cane cane = new Cane(nome, età, razza);
                // aggiungo cane alla lista
                zoo.aggiungiCane(cane);
            //altrimenti se la scelta è 2
            } else if (risposta == 2) {
                //chiedo dati per la creazione
                System.out.println("Inserisci nome: ");
                String nome = myScanner.nextLine();
                System.out.println("Inserisci età: ");
                int età = myScannerInt.nextInt();
                System.out.println("Inserisci razza: ");
                String razza = myScanner.nextLine();
                //creo oggetto di tipo gatto
                Gatto gatto = new Gatto(nome, età, razza);
                // aggiungo gatto alla lista
                zoo.aggiungiGatto(gatto);
            }
            
            contatore++; //incremento il contatore
        } while (contatore <= 3); //verifico la condizioen

        //chiamo metodo che mi stampa tutto
        zoo.stampaInfo();

        //chiudo gli scanner
        myScannerInt.close();
        myScanner.close();
    }
}

//creo una classe padre di nome animale
class Animale {
    protected String nome;
    protected int età;

    //costruttore
    public Animale(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }

    //metodo verso
    public void faiVerso() {
        System.out.println("Fai verso..");
    }
}

//creo un aclasse figlia di tipo cane
class Cane extends Animale {
    //attributi privati della classe
    private String razza;

    //costruttore
    public Cane(String nome, int età, String razza) {
        super(nome, età);
        this.razza = razza;
    }

    //specializzo il metodo genitore
    public void faiVerso() {
        System.out.println("Bau!");
    }

    //getter
    public String getRazza() {
        return razza;
    }

    //setter
    public void setRazza(String razza) {
        this.razza = razza;
    }
    //metodo di stampa
    public void stampaInfo() {
        System.out.println("Nome cane: " + this.nome + ", Età: " + this.età + ", Razza: " + this.getRazza());
    }
}

//creo una classe figlia di tipo gatto
class Gatto extends Animale {
    //attributi privati della classe
    private String razza;

    //costruttore
    public Gatto(String nome, int età, String razza) {
        super(nome, età);
        this.razza = razza;
    }

    //specializzo il metodo genitore
    public void faiVerso() {
        System.out.println("Miao!");
    }

    //getter
    public String getRazza() {
        return razza;
    }

    //setter
    public void setRazza(String razza) {
        this.razza = razza;
    } 

    //metodo di stampa
    public void stampaInfo() {
        System.out.println("Nome gatto: " + this.nome + ", Età: " + this.età + ", Razza: " + this.getRazza());
    }
}

//Creo una clase zoo
class Zoo {
    //dichiarazione di array list
    ArrayList<Cane> cani;
    ArrayList<Gatto> gatti;
    //costruttore
    public Zoo() {
        cani = new ArrayList<>();
        gatti = new ArrayList<>();
    }

    //metodo per aggiungere un cane
    public void aggiungiCane(Cane cane) {
        cani.add(cane);
    }

    // metodo per aggiungere un gatto
    public void aggiungiGatto(Gatto gatto) {
        gatti.add(gatto);
    }
    //metodo per la stampa
    public void stampaInfo() {
        //stampa lista cani
        System.out.println("---Cani---");
        for (Cane cane : cani) {
            cane.stampaInfo();
        }

        //stampa lista gatti
        System.out.println("---Gatti---");
        for (Gatto gatto : gatti) {
            gatto.stampaInfo();
        }
    }

    
}
