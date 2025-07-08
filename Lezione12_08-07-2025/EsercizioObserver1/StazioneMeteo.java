package EsercizioObserver1;

import java.util.ArrayList;
//creo la classe stazione meteo
public class StazioneMeteo implements Subject {
    //attributo e array list
    ArrayList<Display> allDisplay;
    private float temperatura;

    
    //costruttore
    public StazioneMeteo() {
        allDisplay = new ArrayList<>();
    }
    //setto la temperatura
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        //e notifico agli observer
        notifyObservers();
    }

    @Override //implemento il metodo addDisplay
    public void addDisplay(Display display) {
        allDisplay.add(display);
        
    }

    @Override //implemento il metodo notifyObservers
    public void notifyObservers() {
        for (Display display : allDisplay) {
            display.aggiorna(temperatura);
        }
    }

    @Override   //implemento il metodo remove display
    public void removeDisplay(Display display) {
        allDisplay.remove(display);
    }
    
}
//creo la classe observer
class ObserverDisplay implements Display{
    //attributi
    private String name;
    //costruttore
    public ObserverDisplay(String name) {
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

    @Override   //implemento il metodo aggiorna temperatura
    public void aggiorna(float temperatura) {
        System.out.println("Temperatura aggiornata, " + name + " ora ha temperatura: " + temperatura + "° gradi");
    }
}
