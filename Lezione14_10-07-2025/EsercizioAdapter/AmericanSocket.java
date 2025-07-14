package EsercizioAdapter;
//creo la classe american socket
public class AmericanSocket implements Prese{
    //metodo di stampa
    @Override
    public void provideElectricity() {
        System.out.println("Presa americana");
    }
}
//creo la classe British socket
class BritishSocket implements Prese{
    //metodo di stampa
    @Override
    public void provideElectricity() {
        System.out.println("Presa Inglese");
    }
}
//creo la classe adattatore
class SocketAdapter implements EuropeanSocket{
    //dipendenza con l'oggetto americansocket
    private Prese presa;

    //costruttore
    public SocketAdapter(Prese presa) {
        this.presa = presa;

    }

    @Override //sovrascrivo il metodo dell'interfaccia
    public void giveElectricity() {
        System.out.print("Adattatore converte a presa europea da: ");
        presa.provideElectricity();
    }
}
//creo la classe dispositivo europeo
class EuropeanDevice {
    //richiamo la dipendenza dell'interfaccia
    private EuropeanSocket eSocket;
    //costruttore
    public EuropeanDevice(EuropeanSocket eSocket) {
        this.eSocket = eSocket;
    }
    //funzione che mi permette di testare il funzionamento
    public void plugIn () {
        System.out.println("Dispositivo europeo collegato alla prese, corrente fornita! ");
        eSocket.giveElectricity();
    }
}

abstract class CreatorSocket {
    // Factory Method che restituisce un Product
    public abstract Prese factoryMethod();

    // Un metodo del creator che utilizza il prodotto
    public void anOperation() {
        Prese product = factoryMethod();  // creazione del prodotto
        product.provideElectricity(); // uso del prodotto
    }
}

//implementa factoryMethod per ConcreteProductA
class ConcreteAmericanSocket extends CreatorSocket {
    @Override
    public Prese factoryMethod() {
        return new AmericanSocket();
    }
}

//implementa factoryMethod per ConcreteProductB
class ConcreteBritishSocket extends CreatorSocket {
    @Override
    public Prese factoryMethod() {
        return new BritishSocket();
    }
}