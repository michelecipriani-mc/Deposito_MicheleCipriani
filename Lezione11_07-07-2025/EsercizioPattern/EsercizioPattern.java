package EsercizioPattern;

public class EsercizioPattern {
    public static void main(String[] args) {
        //creo la prima istanza
        Logger primaIstanza = Logger.getIstance();
        //richiamo il metodo e ne passo il messaggio
        primaIstanza.scriviMessaggio("Messaggio prima istanza");

        System.out.println();
        //creo la seconda istanza
        Logger secondaIstanza = Logger.getIstance();
        //richiamo il metodo e ne passo il messaggio
        secondaIstanza.scriviMessaggio("Messaggio seconda istanza");

        //verifica che sia sempre la stessa istanza
        if (primaIstanza == secondaIstanza) {
            System.out.println("1° e 2° istanza sono la stessa cosa");
        } else {
            System.out.println("1° e 2° istanza non sono la stessa cosa");
        }
    }
}
