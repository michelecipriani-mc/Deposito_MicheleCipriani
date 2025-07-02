public class ProvaOverride1 {
    public static void main(String[] args) {
        Studente1 s1 = new Studente1("Luca", 20);
        System.out.println(s1); // Chiama automaticamente toString()
    }
}

class Studente1 {
    private String nome;
    private int eta;
    // Costruttore
    public Studente1(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Override del metodo toString()
    @Override
    public String toString() {
        return "Studente: " + nome + ", Età: " + eta;
    }
}
