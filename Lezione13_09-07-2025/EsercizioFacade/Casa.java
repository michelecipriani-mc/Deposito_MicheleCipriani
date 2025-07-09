package EsercizioFacade;

public class Casa {
    public static void main(String[] args) {
        //creo l'oggetto facade
        GestioneLuciFacade casa = new GestioneLuciFacade();
        //chiamo il comando di accensione di tutte le luci
        casa.accendiLuciCasa();
    }
}
