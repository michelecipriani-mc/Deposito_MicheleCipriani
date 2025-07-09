package EsercizioStrategy2;

import java.util.Scanner;

public class Pagamento {
    //istanzio il richiamo dell'oggetto 
    private MetodoPagamento metodoPagamento;
    //dichiaro istanza di pagamento con pattern Singleton
    private static Pagamento instance;

    private Pagamento() {}
    //getter
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
    //setter
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    //costruzione dell'istanza
    public static Pagamento getInstance() {
        if (instance == null) {
            instance = new Pagamento();
        }
        return instance;
    }
    //costruisco il metodo che ne richiama la strategia
    public void strategia(double importo) {
        metodoPagamento.paga(importo);
    }
    
}
//implemento classe strategia CDC
class CDC implements MetodoPagamento {
    @Override //implemento il metodo
    public void paga(double importo) {
        System.out.println("Pagamento effettuato con Carta di Credito per l'importo: " + importo + " euro");
    }
}
//implemento classe strategia PayPal
class PayPal implements MetodoPagamento {
    @Override //implemento il metodo
    public void paga(double importo) {
        System.out.println("Pagamento effettuato con PayPal per l'importo: " + importo + " euro");
    }
}
//classe astratta per pattern decoretor
abstract class PagamentoConPIN implements MetodoPagamento {
    //istanzio la classe cdc
    protected CDC cdc;
    //costruttore
    public PagamentoConPIN(CDC cdc) {
        this.cdc = cdc;
    }

    @Override //implemento il metodo
    public void paga(double importo) {
        cdc.paga(importo);
    }
}
//classe decoretor
class CDCPIN extends PagamentoConPIN {
    //creo uno scanner statico che mi permette di non chiuderlo e non avere il warning
    private static final Scanner scanner = new Scanner(System.in);
    //costruttore
    public CDCPIN(CDC cdc) {
        super(cdc);
    }

    @Override //implemento il metodo
    public void paga(double importo) {
        //richiamo il metodo privato e verifico che sia true
        if (verificaPIN()) {
            super.paga(importo);
        } else {
            System.out.println("PIN errato!");
        }
    }
    
    //metodo privato per la verifica del pin
    private boolean verificaPIN() {
        System.out.println("Inserisci PIN: ");
        String pin = scanner.nextLine();
        return pin.equals("1234");
    }
}