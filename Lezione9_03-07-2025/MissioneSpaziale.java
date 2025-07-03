import java.util.ArrayList;
import java.util.Scanner;

public class MissioneSpaziale {
    public static void main(String[] args) {
        //dichiaro gli scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScannerInt = new Scanner(System.in);
        //Inizializzo la stazione spaziale
        StazioneSpaziale stazioneSpaziale = new StazioneSpaziale();
        //inizializzo l'astronauta a null
        Astronauta astronauta = null;
        //dichiaro variabili
        int risposta;
        //dichiaro la variabile per il menù
        boolean menu = true;

        while (menu) {
            //menù
            System.out.println("---MENU' STAZIONE SPAZIALE---");
            System.out.println("1 - Registra nuovo Astronauta");
            System.out.println("2 - Visualizza dati Astronauta");
            System.out.println("3 - Login (Rigenera Ossigeno)");
            System.out.println("4 - Esci");
            //valorizzo la risposta
            risposta = myScannerInt.nextInt();

            //switch per la gestione della scelta
            switch (risposta) {
                //caso 1 Registro un nuovo astronauta
                case 1:
                    System.out.println("Inserisci nome astronauta: ");
                    String nome = myScanner.nextLine();
                    System.out.println("Inserisci email astronauta: ");
                    String email = myScanner.nextLine();
                    System.out.println("Qual'è il tuo pianeta preferito?");
                    String pianeta = myScanner.nextLine().toLowerCase();

                    //in relazione alla scelta registro uno scenziato o un ispettore
                    if (pianeta.equals("terra")) {
                        astronauta = new Ispettore(nome, email);
                    } else {
                        astronauta = new Scienziato(nome, email);
                    }
                    break;
                //caso 2 stampa dati astronauta
                case 2:
                    //se l'astronauta è loggato
                    if (astronauta != null) {
                        //stampo i suoi dati
                        astronauta.stampaInfo();
                    } else {
                        //altrimenti messaggio di errore
                        System.out.println("Nessun astronauta loggato");
                    }
                    break;
                //caso 3 menù loggato
                case 3:
                    //se l'astronauta è loggato
                    if (astronauta != null) {
                        //genera ossigeno
                        astronauta.rigeneraOssigeno();
                    }
                    //inizializzo una scelta
                    int scelta;
                    //se l'astronauta creato è uno scenziato mostro il suo menù
                    if (astronauta instanceof Scienziato) {
                        do {
                            //menù
                            System.out.println("---MENU' SCENZIATO---");
                            System.out.println("1 - Registra nuovo esperimento");
                            System.out.println("2 - Logout");
                            //valorizzo la risposta
                            scelta = myScannerInt.nextInt();

                            //switch per la gestione della scelta
                            switch (scelta) {
                                //caso 1 registro esperimento
                                case 1:
                                    //chiedo nome esperimento
                                    System.out.print("Inserisci nome esperimento: ");
                                    //salvo l'input in una variabile
                                    String esperimento = myScanner.nextLine();
                                    //aggiungo l'esperimento all'arraylist
                                    astronauta = ((Scienziato) astronauta).aggiungiEsperimento(stazioneSpaziale, esperimento);
                                    //se l'utente è anche uno scenziato capo stampa tutti gli esperimenti
                                    if (astronauta instanceof ScienziatoCapo)
                                        ((ScienziatoCapo) astronauta).stampaTuttiGliEsperimenti(stazioneSpaziale);
                                    break;
                                //caso 2 esco dal menù
                                case 2:
                                    System.out.println("Arrivederci!");
                                    break;
                                //in caso di errore di scelta mi stampa scelta non valida
                                default: System.out.println("Scelta non valida!");
                                    break;
                            }
                        } while (scelta != 2);
                    } else {
                        do {
                            //menù
                            System.out.println("---MENU' ISPETTORE---");
                            System.out.println("1 - Registra nuova perizia");
                            System.out.println("2 - Logout");
                            //valorizzo la risposta
                            scelta = myScannerInt.nextInt();

                            //switch per la gestione della scelta
                            switch (scelta) {
                                //caso 1 registro valutazione
                                case 1:
                                    //chiedo una valutazione 
                                    System.out.print("Inserisci valutazione (1-5): ");
                                    //valorizzo la variabile
                                    int valutazione = myScannerInt.nextInt();
                                    //aggiungo la valutazione
                                    astronauta = ((Ispettore) astronauta).aggiungiValutazione(stazioneSpaziale, valutazione);
                                    //se l'utente è anche un'ispettoreo capo stampa tutti gli esperimenti
                                    if (astronauta instanceof IspettoreCapo)
                                        ((IspettoreCapo) astronauta).stampaTutteLeValutazioni(stazioneSpaziale);
                                    break;
                                //caso 2 esco dal menù
                                case 2:
                                    System.out.println("Arrivederci!");
                                    break;
                                //in caso di errore di scelta mi stampa scelta non valida
                                default: System.out.println("Scelta non valida!");
                                    break;
                            }
                        } while (scelta != 2);
                    }
                //caso 2 stampa dati astronauta
                case 4:
                    System.out.println("Arrivederci!");
                    menu = false;
                    break;
                //in caso di errore di scelta mi stampa scelta non valida
                default: System.out.println("Scelta non valida!");
                    break;
                       
            }
        }
        //chiusura scanner
        myScannerInt.close();
        myScanner.close();
    }
}

//classe base astronauta
class Astronauta {
    //attributi protected in quanto classe base
    protected String nome;
    protected String email;
    protected float creditoOssigeno;
    //costruttore che richiama un metodo personalizzato per la generazione dell'ossigeno
    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.rigeneraOssigeno();
    }
    //metodo che randomizza la generazione dell'ossigeno
    public void rigeneraOssigeno() {
        this.creditoOssigeno = (float) (Math.random() * 101);
    }
    //metodo per la stampa dei dati
    public void stampaInfo() {
        System.out.println("Nome: " + nome + ", Email: " + email + "\nOssigeno: " + creditoOssigeno);
    }

}

//classe derivata Scenziato
class Scienziato extends Astronauta {
    //attributi priovate
    private int azioni = 0;

    //costruttore
    public Scienziato(String nome, String email) {
        super(nome, email);
    }

    //creo un metodo che aggiunge esperimento 
    public Astronauta aggiungiEsperimento(StazioneSpaziale stazione, String esperimento) {
        //aggiungo l'esperimento alla stazione spaziale
        stazione.esperimenti.add(esperimento);
        //incremento gli esperimenti
        azioni++;
        //faccio la verifica delle azioni
        if (azioni >= 3) {
            //se ho raggiunto le tre azioni passo l'oggetto ad una nuova classe Scenziato capo
            return new ScienziatoCapo(this);
        }
        return this;
    }
}

//classe derivata Ispettore
class Ispettore extends Astronauta {
    //attributi priovate
    private int azioni = 0;

    //costruttore
    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    //creo un metodo che aggiunge esperimento 
    public Astronauta aggiungiValutazione(StazioneSpaziale stazione, int valutazione) {
        //aggiungo la valutazione alla stazione spaziale
        stazione.valutazioni.add(valutazione);
        //incremento le valutazioni
        azioni++;
        //faccio la verifica delle azioni
        if (azioni >= 3) {
            //se ho raggiunto le tre azioni passo l'oggetto ad una nuova classe Ispettore Capo
            return new IspettoreCapo(this);
        }
        return this;
    }
}

//creo una classe figlia di Scenziato
class ScienziatoCapo extends Scienziato {
    //costruttore che riceve come parametro l'oggetto scenziato
    public ScienziatoCapo(Scienziato scenziatoBase) {
        super(scenziatoBase.nome, scenziatoBase.email);
        this.creditoOssigeno = scenziatoBase.creditoOssigeno;
    }

    //metodo per la stampa di tutti gli esperimenti
    public void stampaTuttiGliEsperimenti(StazioneSpaziale stazione) {
        stazione.stampaEsperimenti();
    }
}

//creo una classe figlia di Ispettore
class IspettoreCapo extends Ispettore {
    //costruttore che riceve come parametro l'oggetto Ispettore
    public IspettoreCapo(Ispettore ispettoreBase) {
        super(ispettoreBase.nome, ispettoreBase.email);
        this.creditoOssigeno = ispettoreBase.creditoOssigeno;
    }

    //metodo per la stampa di tutte le valutazioni
    public void stampaTutteLeValutazioni(StazioneSpaziale stazione) {
        stazione.stampaValutazioni();
    }
}

//creo la classe contenitore
class StazioneSpaziale {
    //dichiaro i 2 ArrayList del contenitore
    ArrayList<String> esperimenti;
    ArrayList<Integer> valutazioni;
    //costruttore
    public StazioneSpaziale() {
        esperimenti = new ArrayList<>();
        valutazioni = new ArrayList<>();
    }
    //metodo stampa esperimenti
    public void stampaEsperimenti() {
        System.out.println("Esperimenti :");
        for (String esperimento : esperimenti) {
            System.out.println(" - " + esperimento);
        }
    }
    //metodo stampa Valutazioni
    public void stampaValutazioni() {
        System.out.println("Valutazioni :");
        for (Integer valutazione : valutazioni) {
            System.out.println("Valutazione esperimento: " + valutazione);
        }
    }

    
}