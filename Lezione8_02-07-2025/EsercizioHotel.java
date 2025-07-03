import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHotel {
    public static void main(String[] args) {
        //dichiaro variabili
        boolean stampaPrezzo = false;
        int risposta;
        //dichiaro scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScannerStr = new Scanner(System.in);

        //Output guida
        System.out.println("Registra qui il tuo hotel, inserisci nome: ");
        String nomeHotel = myScannerStr.nextLine();
        //creo l'oggetto hotel
        Hotel hotel = new Hotel(nomeHotel);

        do {
            //menù
            System.out.println("---Inserisci camere---");
            System.out.println("1 - Inserisci Camera base");
            System.out.println("2 - Inserisci Suite");
            System.out.println("3 - Mostra riepilogo");
            System.out.println("4 - Esci");
            //valorizzo la risposta
            risposta = myScanner.nextInt();

            //verifico la rispostra se 1 faccio registrare la camera base
            if (risposta == 1) {
                System.out.println("Inserisci il numero della camera: ");
                int numero = myScanner.nextInt();
                System.out.println("Inserisci il prezzo della camera: ");
                float prezzo = myScanner.nextFloat();
                //creo l'oggetto camera e lo aggiungo alla lista
                Camera camera = new Camera(numero, prezzo);
                hotel.addCamera(camera);
                System.out.println("Camera inserita con succeso!");
            //se la risposta e uguale a 2 allora faccio registrare la Suite
            } else if (risposta == 2) {
                System.out.println("Inserisci il numero della Suite: ");
                int numero = myScanner.nextInt();
                System.out.println("Inserisci il prezzo della Suite: ");
                float prezzo = myScanner.nextFloat();
                System.out.println("Inserisci il servizio extra della Suite: ");
                String extra = myScannerStr.nextLine();
                //creo l'oggetto suite e lo aggiungo alla lista
                Suite suite = new Suite(numero, prezzo, extra);
                hotel.addCamera(suite);
                System.out.println("Suite inserita con succeso!");
            } 
            //se invece la risposta è 3 allora faccio la stampa di tutto quello che ha registrato
            if (risposta == 3) {
                //chiedo se stampare o meno il prezzo
                System.out.println("Per le camere base vuoi mostrare il prezzo? (true/false)");
                //valorizzo la scelta
                stampaPrezzo = myScannerStr.hasNextLine();
                System.out.println("---Riepilogo Hotel " + hotel.getNome() + "---");
                //dichiaro una varibile contatore per le suite
                int numeroSuite = 0;
                //ciclo tutte le camere
                for (Camera camera : hotel.camere) {
                    //se è stato scelto di non mostrare il prezzo 
                    if (!stampaPrezzo) {
                        //stampo stanze senza prezzo solo con il numero
                        camera.stampaDettagli(stampaPrezzo);
                    } else if (camera instanceof Suite) {
                        //se è una suite stampo e aumento il contatore delle suite
                        camera.stampaDettagli();
                        numeroSuite = Hotel.contaSuite(hotel.camere);
                    } else { //altrimenti stampo tutto
                        camera.stampaDettagli();
                    }
                    //per dare uno spazio aggiuntivo fra le camere
                    System.out.println();
                }
                //stampo tutte le suite
                System.out.println("Numero di Suite registrate: " + numeroSuite);
            }
        } while (risposta != 4); //controllo la condizione per l'uscita dal ciclo

        //chiudo scanner
        myScannerStr.close();
        myScanner.close();
    }
}

//classe base
class Camera {
    //attributi privati
    protected int numero;
    protected float prezzo;
    //costruttore
    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }
    //getter numero
    public int getNumero() {
        return numero;
    }
    //setter numero
    public void setNumero(int numero) {
        this.numero = numero;
    }
    //getter prezzo
    public float getPrezzo() {
        return prezzo;
    }
    //setter prezzo
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    //metodo base stampa tutti i dettagli
    public void stampaDettagli() {
        System.out.println("Numero camera: " + this.getNumero());
        System.out.println("Prezzo camera: " + this.getPrezzo());
    }

    //metodo overlodato con controllo per stampa prezzo e numero o solo numero
    public void stampaDettagli(boolean bool) {
        if (bool) {
            System.out.println("Numero camera: " + this.getNumero());
            System.out.println("Prezzo camera: " + this.getPrezzo());
        } else {
            System.out.println("Numero camera: " + this.getNumero());
        }
    }
}

//classe derivata
class Suite extends Camera{
    //attributi privati
    private String serviziExtra;

    //costruttore
    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }

    // getter
    public String getServiziExtra() {
        return serviziExtra;
    }

    //setter
    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    @Override //sovrascrivo il metodo della classe padre
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Servizi extra: " + this.getServiziExtra());
    }
}

//classe hotel
class Hotel {
    //dichiaro un arraylist
    ArrayList<Camera> camere;
    private String nome;

    //costruttore
    public Hotel(String nome) {
        camere = new ArrayList<>();
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

    //creo la funzione per aggiungere una camera all'arraylist
    public void addCamera(Camera camera) {
        camere.add(camera);
    }

    //metodo per effettuare il conteggio
    public static int contaSuite(ArrayList<Camera> camere) {
        //istanzio il contatore
        int contaSuite = 0;
        //ciclo tutto l'array
        for (Camera camera : camere) {
            //se l'oggetto è istanziato come suite
            if (camera instanceof Suite) {
                //incremento il contatore
                contaSuite++;
            }
        }
        //restituisco il valore aggiornato
        return contaSuite;
    }
    
}
