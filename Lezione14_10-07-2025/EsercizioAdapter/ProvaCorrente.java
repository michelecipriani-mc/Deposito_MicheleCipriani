package EsercizioAdapter;

public class ProvaCorrente {
    public static void main(String[] args) {
        CreatorSocket americanSocket = new ConcreteAmericanSocket();
        CreatorSocket britishSocket = new ConcreteBritishSocket();
        
        Prese presaA = americanSocket.factoryMethod();
        Prese presaB = britishSocket.factoryMethod();

        //istanzio l'oggetto adattatore
        EuropeanSocket adapterA = new SocketAdapter(presaA);
        EuropeanSocket adapterB = new SocketAdapter(presaB);

        //istanzio l'oggetto device europeo
        EuropeanDevice europeanDeviceVSA = new EuropeanDevice(adapterA);
        EuropeanDevice europeanDeviceVSB = new EuropeanDevice(adapterB);
        //richiamo del metodo che sarà funzionante in relazione alla creazione dell'adapter
        europeanDeviceVSA.plugIn();
        europeanDeviceVSB.plugIn();

    }
}
