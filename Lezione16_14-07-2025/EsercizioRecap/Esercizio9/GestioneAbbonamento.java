package Esercizio9;
/* SINGLETON */
//creo la classe gestione abbonamento
public class GestioneAbbonamento {
    //istanza di gestione privata e statica
    private static GestioneAbbonamento instance;
    //richiamo di abbonamento per la sua gestione
    private Abbonamento abbonamentoAttivo;
    //costruttore
    public GestioneAbbonamento() {}
    //creazione dell'istanza
    public static GestioneAbbonamento getInstance() {
        if (instance == null) {
            instance = new GestioneAbbonamento();
        }
        return instance;
    }
    //getter
    public Abbonamento getAbbonamentoAttivo() {
        return abbonamentoAttivo;
    }
    //setter
    public void setAbbonamentoAttivo(Abbonamento abbonamentoAttivo) {
        this.abbonamentoAttivo = abbonamentoAttivo;
    }
}
