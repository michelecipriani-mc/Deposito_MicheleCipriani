// Interfaccia Notifica
interface Notifica {
    String getMessaggio();
}

// Classe concreta per Notifica di Login
class MessaggioLogin implements Notifica {
    @Override
    public String getMessaggio() {
        return "Notifica di Login:";
    }
}

// Classe concreta per Notifica di Logout
class MessaggioLogout implements Notifica {
    @Override
    public String getMessaggio() {
        return " Notifica di Logout ";
    }
}

// Classe concreta per Notifica di Registrazione
class MessaggioRegister implements Notifica {
    @Override
    public String getMessaggio() {
        return " Notifica di registrazione : ";
    }
}

//Il Creator (astratto) dichiara il factory method
abstract class Creator {
    // Questo è il Factory Method. Le sottoclassi lo implementeranno.
    protected abstract Notifica factoryMethod();

    public void anOperation() {
        // Usa il veicolo creato dalla sottoclasse
        Notifica n = factoryMethod();
        System.out.println("Creazione di una notifica...");
        n.getMessaggio();
    }
}

// ConcreteCreator implementano il factory method
class CreatorNotificaLogin extends Creator {
    @Override
    protected Notifica factoryMethod() {
        // Questa fabbrica crea solo Auto
        return new MessaggioLogin();
    }
}

// ConcreteCreator implementano il factory method
class CreatorNotificaLogout extends Creator {
    @Override
    protected Notifica factoryMethod() {
        // Questa fabbrica crea solo Auto
        return new MessaggioLogout();
    }
}

// I ConcreteCreator implementano il factory method
class CreatorNotificaRegister extends Creator {
    @Override
    protected Notifica factoryMethod() {
        // Questa fabbrica crea solo Auto
        return new MessaggioRegister();
    }
}

// Decorator astratto
abstract class Decorator implements Notifica {
    protected Notifica component;

    public Decorator(Notifica component) {
        this.component = component;
    }

    @Override
    public String getMessaggio() {
        return component.getMessaggio();
    }
}

// Decoratore Concreto
class DecoratorLogin extends Decorator {
    public DecoratorLogin(Notifica component) {
        super(component);
    }

    @Override
    public String getMessaggio() {
        return super.getMessaggio() + "+";
    }
}

// Decoratore Concreto
class DecoratorLogout extends Decorator {
    public DecoratorLogout(Notifica component) {
        super(component);
    }

    @Override
    public String getMessaggio() {
        return super.getMessaggio() + " + " + component.getMessaggio();
    }
}