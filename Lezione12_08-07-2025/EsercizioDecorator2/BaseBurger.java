package EsercizioDecorator2;

import java.util.ArrayList;
//creo la classe base burger
public class BaseBurger implements Hamburger {
    // Istanza privata statica della classe
    private static BaseBurger instance;
    private String name;
    // Costruttore privato per impedire l'istanziazione diretta
    private BaseBurger(String name) {
        this.name = name;
    }
    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }
    // Metodo pubblico statico per ottenere l'unica istanza
    public static BaseBurger getIstance(String name) {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
        instance = new BaseBurger(name);
        }
        // Restituisce l'istanza esistente
        return instance;
    }

    @Override //specializzo il metodo dell'interfaccia
    public String getDescrizione() {
        return "Il Burger da te ordinato contiene: pane, carne, Salsa BBQ";
    }

    @Override //specializzo il metodo dell'interfaccia
    public Double getPrezzo() {
        return 4.99;
    }    
}


//classe decorator astratta
abstract class DecoratorBurger implements Hamburger {
    //istanzio l'oggetto
    protected BaseBurger baseBurger;
    //costruttore
    public DecoratorBurger(BaseBurger baseBurger) {
        this.baseBurger = baseBurger;
    }

    @Override //specializzo il metodo dell'interfaccia
    public String getDescrizione() {
        return baseBurger.getDescrizione();
    }

    @Override //specializzo il metodo dell'interfaccia
    public Double getPrezzo() {
        return baseBurger.getPrezzo();
    }
}


//creo classe per l'extra Cheese
class DecoratorCheese extends DecoratorBurger {
    static double extraCheese = 0.50;
    //costruttore
    public DecoratorCheese(BaseBurger baseBurger) {
        super(baseBurger);
    }

    @Override //specializzo il metodo dell'interfaccia
    public String getDescrizione() {
        return super.getDescrizione() + " con aggiunta di Formaggio";
    }

    @Override //specializzo il metodo dell'interfaccia
    public Double getPrezzo() {
        return super.getPrezzo() + extraCheese;
    }
}

//creo classe per l'extra bacon
class DecoratorBacon extends DecoratorBurger {
    static double extraBacon = 0.80;
    //costruttore
    public DecoratorBacon(BaseBurger baseBurger) {
        super(baseBurger) ;
    }

    @Override //specializzo il metodo dell'interfaccia
    public String getDescrizione() {
        return super.getDescrizione() + " con aggiunta di Bacon";
    }

    @Override //specializzo il metodo dell'interfaccia
    public Double getPrezzo() {
        return super.getPrezzo() + extraBacon;
    }
}


//creo classe ordine
class Ordine {
    //dichiaro l'istanza di ordine
    private static Ordine instance;
    //dichiaro un arraylist
    private ArrayList<DecoratorBurger> extra;
    //costruttore
    public Ordine() {
        extra = new ArrayList<>();
    }
    // Metodo pubblico statico per ottenere l'unica istanza
    public static Ordine getIstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
        instance = new Ordine();
        }
        // Restituisce l'istanza esistente
        return instance;
    }
    //metodo di notifica e aggiunta extra
    public void notifyObservers(DecoratorBurger aggiunta) {
        extra.add(aggiunta);
        System.out.println("Aggiunta registrata!");
    }
    //metodo di stampa riepilogo
    public void riepilogo() {
        for (DecoratorBurger ext : extra) {
            System.out.println(ext.getDescrizione() + " - " + ext.getPrezzo() + " euro");
        }
    }
}