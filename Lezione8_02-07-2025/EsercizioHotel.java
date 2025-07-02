import java.util.ArrayList;

public class EsercizioHotel {
    public static void main(String[] args) {
        
    }
}

//classe base
class Camera {
    //attributi privati
    private int numero;
    private float prezzo;
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

    public void stampaDettagli() {
        System.out.println("Numero camera: " + this.getNumero());
        System.out.println("Prezzo camera: " + this.getPrezzo());
    }

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
