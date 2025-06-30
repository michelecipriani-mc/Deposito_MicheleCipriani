public class EsercizioOggetti {
    public static void main(String[] args) {
        //Creazione nuovi oggetti
        Libri libro1 = new Libri("Il Trono di spade", "George R. R. Martin", 17.90);
        Libri libro2 = new Libri("Il Trono di spade", "George R. R. Martin", 16.90);

        //richiamo il metodo di stampa
        libro1.mostraInfo();
        libro2.mostraInfo();
        //richiamo il metodo contatore
        Libri.contatore();
    }
}

class Libri {
    //dichiarazione attributi oggetto
    static int codice = 0;
    String titolo;
    String autore;
    double prezzo;

    //costruttore
    public Libri(String titolo, String autore, double prezzo) {
        codice++;
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    //metodo per la stampa
    void mostraInfo() {
        System.out.println("Codice: " + codice + "Titolo: " + titolo + "Autore: " + autore + "Prezzo: " + prezzo + "$");
    }

    //metodo stampa contatore
    public static void contatore () {
        System.out.println("Totale libri creati: " + codice);
    }
    
}
