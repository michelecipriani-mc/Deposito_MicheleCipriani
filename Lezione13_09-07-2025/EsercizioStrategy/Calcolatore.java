package EsercizioStrategy;

public class Calcolatore {
    //istanzio il richiamo dell'oggetto operazione
    private Operazione operazione;
    //getter
    public Operazione getOperazione() {
        return operazione;
    }
    //setter
    public void setOperazione(Operazione operazione) {
        this.operazione = operazione;
    }
    //costruisco il metodo che ne richiama la strategia
    public void strategia(int a, int b) {
        operazione.esegui(a, b);
    }

}
//creo la classe Addizione prima strategia
class Addizione implements Operazione{

    @Override //implemento il metodo
    public int esegui(int a, int b) {
        return a + b;
    }
    
}
//creo la classe Addizione seconda strategia
class Moltiplicazione implements Operazione{
    @Override //implemento il metodo
    public int esegui(int a, int b) {
        return a * b;
    }
}