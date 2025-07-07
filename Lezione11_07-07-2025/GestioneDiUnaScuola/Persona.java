package GestioneDiUnaScuola;
//creo la classe astratta persona
public abstract class Persona {
    //con attributi protected
    protected String nome;
    protected int età;
    //costruttore
    public Persona(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }
    //get nome
    public String getNome() {
        return nome;
    }
    //set nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    //get età
    public int getEtà() {
        return età;
    }
    //set età
    public void setEtà(int età) {
        this.età = età;
    }
    //metodi astratti
    public abstract void descriviRuolo();
    public abstract void stampaInfo();
}
//creo la classe studente che estende la classe persona e implementa registrabile
class Studente extends Persona implements Registrabile{
    //attributo specifico privato
    private String classeFrequentata;
    //costruttore
    public Studente(String nome, int età, String classeFrequentata) {
        super(nome, età);
        this.classeFrequentata = classeFrequentata;
    }
    //get classe
    public String getClasseFrequentata() {
        return classeFrequentata;
    }
    //set classe
    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    @Override   //sovrascrivo e specifico il metodo descrivi ruolo ereditato
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe " + this.getClasseFrequentata());
    }

    @Override //sovrascrivo e specifico il metodo registrazione dell'interfaccia
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online!"); 
    }

    @Override //sovrascrivo e specifico il metodo stampa informazioni ereditato
    public void stampaInfo() {
        System.out.println("Il mio nome è " + this.getNome() + " ho " + this.getEtà() + " anni");
    }
}
//creo la classe docente che estende la classe persona e implementa registrabile
class Docente extends Persona implements Registrabile{
    //attributo specifico privato
    private String materia;
    //costruttore
    public Docente(String nome, int età, String materia) {
        super(nome, età);
        this.materia = materia;
    }
    //get materia
    public String getMateria() {
        return materia;
    }
    //set materia
    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override //sovrascrivo e specifico il metodo descrivi ruolo ereditato
    public void descriviRuolo() {
        System.out.println("Sono un docente di " + this.getMateria());
    }

    @Override //sovrascrivo e specifico il metodo registrazione dell'interfaccia
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica!");
    }

    @Override //sovrascrivo e specifico il metodo stampa informazioni ereditato
    public void stampaInfo() {
        System.out.println("Il mio nome è Prof." + this.getNome() + " ho " + this.getEtà() + " anni");
    }  
}
