import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioOggetti3 {
    public static void main(String[] args) {
        //inizializzo una risposta per l'utente
        String risposta;
        //dichiaro una lista di vetture
        Officina officina = new Officina();

        //dichiaro uno scanner
        Scanner myScanner = new Scanner(System.in);
        //Output di benvenuto
        System.out.println("Benvenuto in Officina!");
        //ciclo per far effettuare più consegne
        do {
            //output guida
            System.out.println("Vuole consegnare una macchina? (Si/No)");
            //valorizzo l'input nella variabile
            risposta = myScanner.nextLine().toLowerCase();

            //verifico che la risposta sia corretta
            while (!risposta.equals("si") && !risposta.equals("no")) {
                System.out.println("Inserisci una risposta valida:");
                risposta = myScanner.nextLine().toLowerCase();
            }

            //ciclo while se la risposta è valida
            while (risposta.equals("si")) {
                System.out.println("Inserisca il suo nominativo:"); //inserimento nominativo in input
                String nomeUtente = myScanner.nextLine(); //salva in una variabile
                System.out.println("Inserisca il modello della macchina:"); //inserimento modello in input
                String modello = myScanner.nextLine(); //salva in una variabile
                System.out.println("Inserisca la targa:"); //inserimento taraga in input
                String targa = myScanner.nextLine(); //salva in una variabile
                //creo un nuovo oggetto
                Vettura nuovaVettura = new Vettura(targa, modello, nomeUtente); 
                //lo inserisco nell' Arraylist officina
                officina.consegnaAuto(nuovaVettura);

                //chiedo se vuole inserire una nuova auto
                System.out.println("Vuoi inserire una nuova macchina? ");
                //valido la risposta nella variabile
                risposta = myScanner.nextLine().toLowerCase();

                //verifico la risposta
                while (!risposta.equals("si") && !risposta.equals("no")) {
                    System.out.println("Inserisci una risposta valida:");
                    risposta = myScanner.nextLine().toLowerCase();
                }
            }
        } while (!risposta.equals("no")); // controllo sulla variabile

        //stampo la lista delle auto
        System.out.println("Ecco le auto attualmente presenti in officina:");
        //richiamo il metodo stampa lista officina
        officina.stampaListaOfficina();
        //chiusura scanner
        myScanner.close();
    }
}

//creo una classe officina
class Officina {
    //Arraylist di vetture
    ArrayList<Vettura> vetture;

    //costruttore
    public Officina() {
        vetture = new ArrayList<>();
    }

    //metodo per la consegna auto
    public void consegnaAuto(Vettura vettura) {
        //aggiungo l'oggetto all'arraylist
        vetture.add(vettura);
        //stampa di avvunuta consegna
        System.out.println("Perfetto " + vettura.getProprietario() + " auto consegnata!");
    }

    //metodo per la stampa della lista delle auto presenti
    public void stampaListaOfficina() {
        //verifico se la lista è vuota
        if (vetture.isEmpty()) {
            //se vuota stampo lista vuota
            System.out.println("Non ci sono auto in officina!");
        } else {
            //altrimenti stampo la lista
            System.out.println("Le auto in officina sono: ");
            //ciclo e stampo tutte le auto
            for (Vettura vettura : vetture) {
                vettura.stampaAuto();
            }
        }
    }
}

//creo una classe auto
class Vettura {
    //dichiaro tre variabili private per la vettura
    private String targa;
    private String modello;
    private String proprietario;

    //costruttore
    public Vettura(String targa, String modello, String proprietario) {
        this.targa = targa;
        this.modello = modello;
        this.proprietario = proprietario;
    }
    
    //getter e setter
    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    //metodo per la stampa del veicolo
    public void stampaAuto() {
        System.out.println("Proprietario: " + this.getProprietario() + ", Veicolo: " + this.getModello() + ", Targa: " + this.getTarga());
    }

}
