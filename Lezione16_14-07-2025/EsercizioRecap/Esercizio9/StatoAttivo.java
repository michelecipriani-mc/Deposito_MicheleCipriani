package Esercizio9;
/* PATTERN STATE */
public class StatoAttivo implements StatoAbbonamento{
    //attributi
    private String nomeExtra;
    //costruttore
    public StatoAttivo(String nomeExtra) {
        this.nomeExtra = nomeExtra;
    }

    @Override //override del metodo mostra stato
    public void mostraStato() {
        System.out.println("Extra " + nomeExtra + " attivato!");
    }
}

class StatoDisattivo implements StatoAbbonamento{
    //attributi
    private String nomeExtra;
    //costruttore
    public StatoDisattivo(String nomeExtra) {
        this.nomeExtra = nomeExtra;
    }

    @Override //override del metodo mostra stato
    public void mostraStato() {
        System.out.println("Extra " + nomeExtra + " disattivato!");
    }
}

class GestioneStato {
    //richiamo della dipendenza
    private StatoAbbonamento statoAbbonamento;
    //setter
    public void setStatoAbbonamento(StatoAbbonamento statoAbbonamento) {
        this.statoAbbonamento = statoAbbonamento;
    }
    //metodo di richiamo dello stato dell'extra
    public void eseguiOperazione() {
        statoAbbonamento.mostraStato();
    }
}

