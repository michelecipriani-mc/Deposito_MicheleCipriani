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

class Studente extends Persona implements Registrabile{
    private String classeFrequentata;

    public Studente(String nome, int età, String classeFrequentata) {
        super(nome, età);
        this.classeFrequentata = classeFrequentata;
    }

    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe " + this.getClasseFrequentata());
    }

    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online!"); 
    }

    @Override
    public void stampaInfo() {
        System.out.println("Il mio nome è " + this.getNome() + " ho " + this.getEtà() + " anni");
    }
}

class Docente extends Persona implements Registrabile{
    private String materia;

    public Docente(String nome, int età, String materia) {
        super(nome, età);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di " + this.getMateria());
    }

    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica!");
    }

    @Override
    public void stampaInfo() {
        System.out.println("Il mio nome è Prof." + this.getNome() + " ho " + this.getEtà() + " anni");
    }  
}
