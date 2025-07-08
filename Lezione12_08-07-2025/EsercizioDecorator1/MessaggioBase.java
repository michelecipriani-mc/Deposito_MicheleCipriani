package EsercizioDecorator1;
//implemento la classe messaggio base che estende l'interfaccia messaggio
public class MessaggioBase implements Messaggio{
    @Override //specifico il metodo dell'interfaccia
    public String getContenuto() {
        return "Ciao, sto imparando il pattern Decorator";
    }
}
//creo una classe astratta che mi chiede un oggetto messaggio base e implementa l'interfaccia messaggio
abstract class DecoratorText implements Messaggio{
    //creo la dipendenza dell'oggeto messaggio
    protected MessaggioBase messaggio;
    //costruttore
    public DecoratorText(MessaggioBase messaggio) {
        this.messaggio = messaggio;
    }

    @Override //specifico il metodo dell'interfaccia
    public String getContenuto() {
        return messaggio.getContenuto();
    }
}
//creo la classe decoratore maiuscolo che estende DecoratorText
class DecoratoreMaiuscolo extends DecoratorText {
    //costruttore
    public DecoratoreMaiuscolo(MessaggioBase messaggio) {
        super(messaggio);
    }

    @Override //specifico il metodo del padre proveniente dall'interfaccia
    public String getContenuto() {
        return super.getContenuto().toUpperCase();
    }    
}

//creo la classe decoratore maiuscolo che estende DecoratorText
class DecoratoreMinuscolo extends DecoratorText {
    //costruttore
    public DecoratoreMinuscolo(MessaggioBase messaggio) {
        super(messaggio);
    }

    @Override //specifico il metodo del padre proveniente dall'interfaccia
    public String getContenuto() {
        return super.getContenuto().toLowerCase();
    }    
}
