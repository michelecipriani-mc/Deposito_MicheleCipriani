import java.util.ArrayList;

public class Risposta3 {
    public static void main(String[] args) {
        //dichiaro un array list
        ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();
        //creo due oggetti uno di tipo auto e uno di tipo moto
        veicoli.add(new Auto("Ferrari", "488 Pista", 2016, 2));
        veicoli.add(new Moto("Harlay Devidson", "Dyna Super Glide", 1971, "Hollywood"));

        //ciclo l'array list e stampo con il metodo della classe di creazione
        for (Veicolo veicolo : veicoli) {
            if (veicolo instanceof Auto) {
                System.out.println(veicolo.toString()); 
            } else if (veicolo instanceof Moto) {
                System.out.println(veicolo.toString()); 
            } else {
                System.out.println(veicolo.toString()); 
            }             
        }

    }
}
//classe padre
class Veicolo {
    //attributi
    protected String marca;
    protected String modello;
    protected int anno;
    //costruttore
    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }
    //getter e setter
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String toString() {
        return "Il veicolo è di casa: " + marca + ", modello: " + modello + ", prodotta nell'anno: " + anno;
    }
}

class Auto  extends Veicolo{
    //attributi
    private int numPorte;
    //costruttore
    public Auto(String marca, String modello, int anno, int numPorte) {
        super(marca, modello, anno);
        this.numPorte = numPorte;
    }
    //getter e setter
    public int getNumPorte() {
        return numPorte;
    }
    public void setNumPorte(int numPorte) {
        this.numPorte = numPorte;
    }
    @Override //override del metodo toString
    public String toString() {
        return "La macchina è di casa: " + marca + ", modello: " + modello + ", prodotta nell'anno: " + anno + ", è stata prodotta con " + this.getNumPorte() + " porte";
    }
}

class Moto extends Veicolo{
    //attributi
    private String tipoManubrio;
    //costruttore
    public Moto(String marca, String modello, int anno, String tipoManubrio) {
        super(marca, modello, anno);
        this.tipoManubrio = tipoManubrio;
    }
    //getter e setter
    public String getTipoManubrio() {
        return tipoManubrio;
    }

    public void setTipoManubrio(String tipoManubrio) {
        this.tipoManubrio = tipoManubrio;
    }

    @Override //override del metodo toString
    public String toString() {
        return "La moto è di casa: " + marca + ", modello: " + modello + ", prodotta nell'anno: " + anno + ", è stata prodotta con il manubrio " + this.getTipoManubrio();
    }

}
