import java.util.ArrayList;
import java.util.List;

public class SocialNetwork implements Subject {
    private List<Osservatore> utenti = new ArrayList<>();
    private static SocialNetwork instance;

    public SocialNetwork() {}

    public static SocialNetwork getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
        instance = new SocialNetwork();
        }
        // Restituisce l'istanza esistente o appena creata
        return instance;
    }

    @Override
    public void rimuoviUtente(Osservatore observer) {
        if (utenti.contains(observer)) {
            System.out.println("Rimozione utente: " + observer);
            utenti.remove(observer);
        } else {
            System.out.println("Utente non trovato: ");
        }
        
    }

    @Override
    public void notifyObservers() {
        for (Osservatore observer : utenti) {
            observer.update("Notifica per tutti gli utenti del social network.");
        }
    }

    @Override
    public void inserisciUtente(Osservatore observer) {
        if (!utenti.contains(observer)) {
            System.out.println("Rimozione utente: " + observer);
            utenti.add(observer);
        } else {
            System.out.println("Utente gia registrato: ");
        }
    }

    @Override
    public void login() {
        
        
    }

    @Override
    public void register() {
        
        
    }

    


}

interface Osservatore {
    void update(String message);
}

interface Subject {
    void inserisciUtente(Osservatore observer);
    void rimuoviUtente(Osservatore observer);
    void notifyObservers();
    void login();
    void register();
}