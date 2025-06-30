import java.util.ArrayList;

public class ProvaClassi1 {
     public static void main(String[] args) {
        //istanzio un nuovo oggetto calcolatrice
        Calcolatrice calc = new Calcolatrice();
        //invoco il metodo saluta
        calc.saluta();
        //invoco il metodo somma e lo salvo nella variabile risultato
        int risultato = calc.somma(5, 3);
        //stampo ciò che salvo nella variabile risultato
        System.out.println("La somma è: " + risultato);


        //creo un arraylist di oggetti
        ArrayList<Auto2> autoList = new ArrayList<>();
        //istanzio nuovi oggetti
        autoList.add(new Auto2("Tesla", 2023));
        autoList.add(new Auto2("Ford", 2020));
        //ciclo l'arraylist e ne stampo gli oggetti contenuti
        for (Auto2 auto : autoList) {
            System.out.println(auto.marca + " - " + auto.anno);
        }
    }
}

//creo la classe calcolatrice
class Calcolatrice {
    // Metodo con ritorno
    int somma(int a, int b) {
        return a + b;
    }

    // Metodo senza ritorno
    void saluta() {
        System.out.println("Ciao!");
    }

}

//creo la classe auto
class Auto2 {
    //istanzio gli attributi dell'oggetto
    String marca;
    int anno;

    //costruttore personalizzato
    Auto2(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

}