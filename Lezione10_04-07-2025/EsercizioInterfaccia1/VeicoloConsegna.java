package EsercizioInterfaccia1;
//classe astratta padre
public abstract class VeicoloConsegna {
    //attributi protected
    protected String targa;
    protected float caricoMassimo;
    //costruttore
    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }
    //metodo astratto
    public abstract void consegnaPacco(String destinazione);
    //metodo reale
    public void stampaInfo() {
        System.out.println(targa + " - " + caricoMassimo);
    }
}

//creo la classe figlia furgone
class Furgone extends VeicoloConsegna implements Tracciabile{
    //costruttore
    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override //override del metodo astratto
    public void consegnaPacco(String destinazione) {
        System.out.println("Consegna prevista via strada dal furgone: " + this.targa + " in arrivo presso la destinazione seguente: " + destinazione);
    }

    @Override //override del metodo di stampa
    public void stampaInfo() {
        System.out.println("Parametri furgone:\n Targa - Carico Massimo");
        super.stampaInfo();
    }

    @Override // override del metodo interfaccia
    public void tracciaConsegna(String codiceTracking) {
        int tempo = (int)(Math.random() * 60);
        System.out.println("La tua consegna con codice: " + codiceTracking + " è prevista tra: " + tempo + " minuti");
    }
}

//creo la classe figlia drone
class Drone extends VeicoloConsegna implements Tracciabile{
    //costruttore
    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override //override del metodo astratto
    public void consegnaPacco(String destinazione) {
        int numero = (int)(Math.random() * 40000);
        String codiceTracking = String.valueOf(numero);
        this.tracciaConsegna(codiceTracking);
        System.out.println("Consegna prevista via aerea con drone in arrivo presso la destinazione seguente: " + destinazione);
    }

    @Override //override del metodo di stampa
    public void stampaInfo() {
        System.out.println("Parametri Drone:\n Targa - Carico Massimo");
        super.stampaInfo();
    }

    @Override // override del metodo interfaccia
    public void tracciaConsegna(String codiceTracking) {
        int tempo = (int)(Math.random() * 60);
        System.out.println("La tua consegna con codice: " + codiceTracking + " è prevista tra: " + tempo + " minuti");
    }
}
