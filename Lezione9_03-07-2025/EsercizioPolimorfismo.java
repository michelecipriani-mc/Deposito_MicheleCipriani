import java.util.ArrayList;

public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<Persona>();
        //dichiaro 2 oggetti persona
        persone.add(new Persona("Michele"));
        persone.add(new Persona("Nancy"));
        //creo un oggetto pirata
        persone.add(new Pirata("Jack"));

        //ciclo for per stampare tutti i metodi saluta di ogni oggetto
        for (Persona persona : persone) {
            persona.saluta();
        }

    }
}

//creo la classe di base
class Persona {
    //attributo di tipo protected
    protected String nome;
    //costruttore
    public Persona(String nome) {
        this.nome = nome;
    }
    //getter
    public String getNome() {
        return nome;
    }
    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }    
    //metodo per salutare
    public void saluta() {
        System.out.println("Ciao! Il mio nome è " + this.getNome());
    }
}

//creo la classe derivata
class Pirata extends Persona {
    //costruttore
    public Pirata(String nome) {
        super(nome);
    }  
    //metodo per salutare
    @Override
    public void saluta() {
        System.out.println("Il mare è la nostra libertà, il bottino la nostra ricompensa!");
    }
}
