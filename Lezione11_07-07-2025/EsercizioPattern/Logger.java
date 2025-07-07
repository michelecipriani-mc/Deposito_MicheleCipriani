package EsercizioPattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//creo la classe singleton Logger
public class Logger {
    //istanza privata
    private static Logger istanza;

    //costruttore
    private Logger () {
        System.out.println("Logger creato!");
    }

    //metodo per ottenere l'unica istanza
    public static Logger getIstance() {
        //se istanza e nulla
        if (istanza == null) {
            //crea nuova istanza
            istanza = new Logger();
        }
        //restituisci l'istanza 
        return istanza;
    }
    //metodo per scrivere un messaggio con data e ora
    public void scriviMessaggio(String messaggio) {
        //creo la variabile dataOra a cui passo la data odierna formattata
        String dataOra = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        //e ne stampo il messaggio
        System.out.println("- Data " + dataOra + "\"" + messaggio + "\"");
    }
}
