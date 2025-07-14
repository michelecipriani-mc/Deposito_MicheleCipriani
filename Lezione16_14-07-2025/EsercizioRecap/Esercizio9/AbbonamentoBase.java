package Esercizio9;
/* DECORATOR */
//creo la classe abbonamento base che implementa l'interfaccia abbonamento
public class AbbonamentoBase implements Abbonamento {
    @Override //override del metodo costo
    public double costoAbbonamento() {
        return 5.99;
    }

    @Override //override del metodo tipo
    public String tipoAbbonamento() {
        return "Abbonamento di base";
    }
}
//creo la classe astratta per il decorator 
abstract class AbbonamentoDecorator implements Abbonamento {
    //dichiaro la dipendenza dell'oggetto abbonamento
    protected Abbonamento abbonamento;
    //Costruttore
    public AbbonamentoDecorator(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    @Override //override del metodo 
    public double costoAbbonamento() {
        return abbonamento.costoAbbonamento();
    }
    @Override //override del metodo 
    public String tipoAbbonamento() {
        return abbonamento.tipoAbbonamento();
    }
}
//decoratore concreto x abbonamento premium
class AbbonamentoPremium extends AbbonamentoDecorator {
    //contatore
    public AbbonamentoPremium (Abbonamento abbonamento) {
        super(abbonamento);
    }

    @Override //override del metodo 
    public double costoAbbonamento() {
        return super.costoAbbonamento() + 2.99;
    }

    @Override //override del metodo 
    public String tipoAbbonamento() {
        return super.tipoAbbonamento() + ", senza pubblicità!";
    }
}

//decoratore concreto x abbonamento premium
class Abbonamento4k extends AbbonamentoPremium {
    //contatore
    public Abbonamento4k (Abbonamento abbonamento) {
        super(abbonamento);
    }

    @Override //override del metodo 
    public double costoAbbonamento() {
        return super.costoAbbonamento() + 1.99;
    }

    @Override //override del metodo 
    public String tipoAbbonamento() {
        return super.tipoAbbonamento() + ", con visibilità in 4K!";
    }
}