package EsercizioObserver2;

import java.util.ArrayList;
import java.util.List;

//creo la classe agenzia borsa
public class AgenziaBorsa implements Oggetto{
    //arraylist dichiarato
    List<Investitore> investitori;
    //attributi privati
    private String nome; 
    private double valore;
    //costruttore
    public AgenziaBorsa(String nome, double valore) {
        investitori = new ArrayList<>();
        this.nome = nome;
        this.valore = valore;
    }
    //getter e setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValore() {
        return valore;
    }
    public void setValore(double valore) {
        this.valore = valore;
    }

    @Override //implemento il metodo aggiungi
    public void addInvestitore(Investitore investitore) {
        investitori.add(investitore);
        
    }

    @Override //implemento il metodo di notifica
    public void notificaObservers() {
        for (Investitore investitore : investitori) {
            investitore.notifica(nome, valore);
        } 
    }

    @Override //implemento il metodo rimuovi
    public void removeInvestitore(Investitore investitore) {
        investitori.remove(investitore);
        
    }

    //stampa totale investitori
    public void stampaInvestitori(){
        for (Investitore investitore : investitori) {
            investitore.notifica(nome, valore);
        }
    }
}

//creo la classe observer
class Azione implements Investitore{
    //costruttore
    public Azione () {}

    @Override //implemento il metodo notifica
    public void notifica(String azione, double valore) {
        System.out.println("Azione " + azione + " aggiornata con valore " + valore);
        
    }

}