package EsercizioObserver1;

public class Meteo {
    public static void main(String[] args) {
        //Creo l'oggetto stazione meteo
        StazioneMeteo stazioneMeteo = new StazioneMeteo();
        //creo i due oggetti observer 
        ObserverDisplay displayConsole = new ObserverDisplay("Display Console");
        ObserverDisplay displayMobile = new ObserverDisplay("Display Mobile");
        //aggiungo oggetti all'arraylist
        stazioneMeteo.addDisplay(displayConsole);
        stazioneMeteo.addDisplay(displayMobile);
        //ne setto la temperatura
        stazioneMeteo.setTemperatura(15);
    }
}
