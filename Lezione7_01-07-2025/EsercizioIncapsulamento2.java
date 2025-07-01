import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento2 {
    public static void main(String[] args) {
        //dichiaro lo scanner
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        //chiedo il nome della compagnia aerea
        System.out.println("Inserisci il Nome della Compagnia aerea: ");
        //inizializzo la variabile con l'input
        String nomeCompagnia = scanner.nextLine();
        //creo l'oggetto compagnia aerea
        CompagniaAerea compagniaAerea = new CompagniaAerea(nomeCompagnia);

        //dichiaro la variabile per la scelta
        int scelta;
        //ciclo do while per il menù
        do {
            //stampo il menù
            System.out.println("---MENU' COMPAGNIA AEREA---");
            System.out.println("1 - Gestione piloti");
            System.out.println("2 - Gestione aerei");
            System.out.println("3 - Visualizza intera compagnia");
            System.out.println("4 - Esci");
            //valorizzo la variabile con l'input
            scelta = scanner.nextInt();
            //switch per la gestione della scelta
            switch (scelta) {
                //caso 1 richiamo il menù piloti
                case 1:
                    compagniaAerea.menùPilota(scanner, scanner1);
                    break;
                //caso 2 richiamo il menù aerei
                case 2:
                    compagniaAerea.menùAereo(scanner, scanner1);
                    break;
                //caso 3 richiamo il menù di stampa generale
                case 3:
                    compagniaAerea.menuStampa();
                    break;
                //caso 4 esco dal menù
                case 4:
                    System.out.println("Arrivederci!");
                    break;
                //in caso di errore di scelta mi stampa scelta non valida
                default: System.out.println("Scelta non valida!");
                    break;
            }
        } while (scelta != 4); //verifico la condizione di uscita

        //chiudo lo scanner
        scanner.close();
    }
}

//creo classe compagnia aerea
class CompagniaAerea {
    //dichiarazione ArrayList
    ArrayList<Aereo> flotta;
    ArrayList<Pilota> piloti;

    //dichiarazione attributi
    private String nome;

    //contatore
    public CompagniaAerea(String nome) {
        flotta = new ArrayList<>();
        piloti = new ArrayList<>();
        this.nome = nome;
    }

    //getter
    public String getNome() {
        return nome;
    }

    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    //metodo di creazione pilota
    private void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
        System.out.println("Pilota aggiunto con successo!");
    }

    //metodo per eliminare pilota
    private void eliminaPilota(Pilota pilota) {
        piloti.remove(pilota);
        System.out.println("Pilota rimosso con successo!");
    }

    // metodo per aggiungere aereo
    private void aggiungiAereo(Aereo aereo) {
        flotta.add(aereo);
        System.out.println("Aereo aggiunto con successo!");
    }

    //metodo per eliminare aereo
    private void rimuoviAereo(Aereo aereo) {
        flotta.remove(aereo);
        System.out.println("Aereo rimosso con successo!");
    }

    //stampa flotta e piloti
    private void stampaListe() {
        System.out.println("Nella flotta abbiamo questi aerei: ");
        for (Aereo aereo : flotta) {
            System.out.println("Modello: " + aereo.getModello() + ", N° posti: " + aereo.getNumPosti() + ", Codice: " + aereo.getCodice());
        }
        System.out.println("e questi piloti: ");
        for (Pilota pilota : piloti) {
            System.out.println("Nome: " + pilota.getNome() + ", Brevetto: " + pilota.getBrevetto() + ", Ore volo: " + pilota.getOreVolo());
        }
    }

    //menu pilota
    public void menùPilota(Scanner scanner, Scanner scanner1) {
        //dichiaro la variabile per la scelta
        int scelta;
        //mostro il menù
        System.out.println("---Menù Pilota---");
        System.out.println("1 - Inserisci pilota");
        System.out.println("2 - Rimuovi pilota");
        //valorizzo la scelta con l'input
        scelta = scanner1.nextInt();

        //verifico la correttezza della scelta
        while (scelta < 1 || scelta > 2) {
            System.out.println("Inserisci un comando valido: ");
            scelta = scanner1.nextInt();
        }

        //chiedo i parametri per il pilota
        System.out.println("Inserisci Nome: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Inserisci Brevetto: ");
        String brevetto = scanner.nextLine();
        System.out.println("Inserisci ore volo: ");
        int oreVolo = scanner1.nextInt();

        //creo l'oggetto pilota
        Pilota pilota = new Pilota(nome, brevetto, oreVolo);

        //in relazione alla scelta richiamo il metodo aggiungi o elimina
        if (scelta == 1) {
            aggiungiPilota(pilota);
        } else if (scelta == 2) {
            eliminaPilota(pilota);
        } else {
            System.out.println("Scelta non valida!");
        }
    }

    //menu aereo
    public void menùAereo(Scanner scanner, Scanner scanner1) {
        //dichiaro la variabile per la scelta
        int scelta;
        //mostro il menù
        System.out.println("---Menù Aereo---");
        System.out.println("1 - Inserisci aereo");
        System.out.println("2 - Rimuovi aereo");
        //valorizzo la scelta con l'input
        scelta = scanner1.nextInt();

        //verifico la correttezza della scelta
        while (scelta < 1 || scelta > 2) {
            System.out.println("Inserisci un comando valido: ");
            scelta = scanner1.nextInt();
        }

        //chiedo i parametri dell'aereo
        System.out.println("Inserisci Modello: ");
        String modello = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Inserisci Codice: ");
        String codice = scanner.nextLine();
        System.out.println("Inserisci n° posti: ");
        int posti = scanner1.nextInt();

        //creo l'ogetto
        Aereo aereo = new Aereo(modello, codice, posti);

        //in relazione alla scelta richiamo il metodo aggiungi o elimina
        if (scelta == 1) {
            aggiungiAereo(aereo);
        } else if (scelta == 2) {
            rimuoviAereo(aereo);
        } else {
            System.out.println("Scelta non valida!");
        }
    }

    //menu stampa totale
    public void menuStampa() {
        //richiamo metodo stampa liste
        stampaListe();
    }
}

//creo la classe Pilota
class Pilota {
    //attributi privati
    private String nome;
    private String brevetto;
    private int oreVolo;
    //costruttore
    public Pilota(String nome, String brevetto, int oreVolo) {
        this.setNome(nome);
        this.setBrevetto(brevetto);
        this.setOreVolo(oreVolo);
    }
    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBrevetto() {
        return brevetto;
    }

    public void setBrevetto(String brevetto) {
        this.brevetto = brevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        //controllo ore positive
        if (oreVolo >= 0) {
            this.oreVolo = oreVolo; 
        } else {
            System.out.println("Errore: ore di volo non valide!");
        }
    }
}

//creo la classe Aereo
class Aereo {
    //attributi privati
    private String modello;
    private String codice;
    private int numPosti;
    //costruttore
    public Aereo(String modello, String codice, int numPosti) {
        this.setModello(modello);
        this.setCodice(codice);
        this.setNumPosti(numPosti);
    }
    //getter e setter
    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        //controllo numero posti positivo
        if (numPosti > 0) {
            this.numPosti = numPosti; 
        } else {
            System.out.println("Errore: numero di posti non valido!");
        }
    }

}

