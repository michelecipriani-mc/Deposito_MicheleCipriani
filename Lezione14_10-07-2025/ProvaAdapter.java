// Client
public class ProvaAdapter {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}

// Target interface
interface Target {
    void request();
}

// Adaptee
class Adaptee {
    void specificRequest() {
        System.out.println("Richiesta specifica eseguita.");
    }
}

// Adapter
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

