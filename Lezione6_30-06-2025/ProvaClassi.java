public class ProvaClassi {
    public static void main(String[] args) {
        //Creo un nuovo oggetto auto
        Auto miaAuto = new Auto();
        //asseganzione dei valori per ogni attributo dell'oggetto
        miaAuto.marca = "Ferrari 488 pista";
        miaAuto.anno = 2018;
        miaAuto.prezzo = 680000.00;

        //stampo tutte le info dell'oggetto
        miaAuto.mostraInfo();

        //creo nuovi oggetti studente
        Studenti studente = new Studenti();
        studente.Studente("Michele");
        studente.Studente("Antonio");
    }
}

//creazione della classe auto
class Auto {
    //dichiarazione attributi
    String marca;
    int anno;
    double prezzo;

    //funzione per mostrare le informazioni
    void mostraInfo() {
        System.out.println(marca + " " + anno + " "  + "-$" + prezzo);
    }
}

//creazione della classe studente
class Studenti {
    //creazione attributi
    String nome;
    static int totaleStudente = 0;

    //costruttore
    void Studente (String nome) {
        this.nome = nome;
        totaleStudente++;
    }

    
}
