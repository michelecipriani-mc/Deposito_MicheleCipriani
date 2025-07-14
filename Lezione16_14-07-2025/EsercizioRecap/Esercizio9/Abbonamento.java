package Esercizio9;
//creo l'interfaccia abbonamento
public interface Abbonamento {
    String tipoAbbonamento();
    double costoAbbonamento();
}

//interfaccia per la visibilità dello stato dell'abbonamentro
interface StatoAbbonamento {
    public void mostraStato();
}
