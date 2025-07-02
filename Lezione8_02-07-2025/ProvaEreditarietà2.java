public class ProvaEreditarietà2 {
    public static void main(String[] args) {
        //creo un nuovo oggetto studente
        Studente s = new Studente("Luca", "ITIS Informatico");
        //invoco il metodo
        s.saluta();
    }
}

// Classe base
class Persona {
    //attributo protected
    protected String nome;
    //costruttore del padre
    public Persona(String nome) {
        this.nome = nome;
    }

    //metodo saluta
    public void saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}


// Classe derivata
class Studente extends Persona {
    //attrinuto private
    private String scuola;
    // Costruttore: usa super per chiamare il costruttore della classe madre
    public Studente(String nome, String scuola) {
        super(nome); // chiama il costruttore di Persona
        this.scuola = scuola;
    }
    // Metodo: usa super per richiamare il metodo saluta della superclasse
    public void saluta() {
        super.saluta(); // chiama saluta() da Persona
        System.out.println("Vado alla scuola " + scuola);
    }
}