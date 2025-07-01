public class ProvaModificatoreDiAccesso {
    public static void main(String[] args) {
        //creo un oggetto di tipo person
        Person myObj = new Person("Michele", 26);
        
        //Stampiamo il nome
        System.out.println(myObj.getName());
        myObj.stampaStatus();
    }
}

class Person { 
    private String name; // private 
    private int eta;

    // Costruttore pubblico
    public Person(String nome, int eta) {
        this.name = nome;
        this.eta = eta;
    }

    public String getName() { // Getter
        return name;  
    }

    public void setName(String newName) { // Setter
        this.name = newName;  
    } 

    // Metodo privato utilizzato dalla classe
    private boolean verificaMaggiorenne() {
        return this.eta >= 18;
    }

    // Metodo pubblico che fa uso del metodo privato
    public void stampaStatus() {
        if (verificaMaggiorenne()) {
                System.out.println(this.getName() + " è maggiorenne.");
        } else {
                System.out.println(this.getName() + " non è maggiorenne.");
        }
    }
}