package EsercizioObserver2;
//interfaccia investitore
public interface Investitore {
    public void notifica(String azione, double valore);
}

//interfaccia Oggetto
interface Oggetto {
    public void addInvestitore(Investitore investitore);
    public void removeInvestitore(Investitore investitore);
    public void notificaObservers();
}