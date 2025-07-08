package EsercizioObserver1;
//interfaccia display
public interface Display {
    public void aggiorna(float temperatura);
}
//interfaccia Oggetto
interface Subject {
    public void addDisplay(Display display);
    public void removeDisplay(Display display);
    public void notifyObservers();
}

