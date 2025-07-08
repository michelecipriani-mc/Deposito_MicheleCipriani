package EsercizioDecorator1;

public class ScriviMessaggio {
    public static void main(String[] args) {
        //creo l'oggeto base meassaggio
        MessaggioBase messaggioBase = new MessaggioBase();
        //creo l'oggetto messaggio decorato con maiuscolo
        DecoratoreMaiuscolo messaggioMaiuscolo = new DecoratoreMaiuscolo(messaggioBase);
        //creo l'oggetto messaggio decorato con minuscolo
        DecoratoreMinuscolo messaggioMinuscolo = new DecoratoreMinuscolo(messaggioBase);
        //richiamo i metodi per i vari oggetti
        System.out.println(messaggioBase.getContenuto());
        System.out.println(messaggioMaiuscolo.getContenuto());
        System.out.println(messaggioMinuscolo.getContenuto());
    }
}
