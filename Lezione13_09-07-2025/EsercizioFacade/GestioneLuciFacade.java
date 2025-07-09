package EsercizioFacade;
//creo la classe facade
public class GestioneLuciFacade {
    //inizializzo oggetto camera
    private LuceCamera camera = new LuceCamera();
    //inizializzo oggetto cucina
    private LuceCucina cucina = new LuceCucina();
    //metodo che richiama tutti i metodi degli oggetti istanziati
    public void accendiLuciCasa() {
        System.out.println("Alexa, accendi tutte le luci!");
        camera.accendi();
        cucina.accendi();
    }
}
//creo la classe Luce camera
class LuceCamera {
    public void accendi() {
        System.out.println("Ciao, luci camera accese!");
    }
}
//creo la classe Luce cucina
class LuceCucina {
    public void accendi() {
        System.out.println("Ciao, luci cucina accese!");
    }
}