package EsercizioObserver2;

//creo la classe investitore privato come singleton
public class InvestitorePrivato implements Investitore{
    // Istanza privata statica della classe
    private static InvestitorePrivato instance;
    private String name;
    // Costruttore privato per impedire l'istanziazione diretta
    private InvestitorePrivato(String name) {
        this.name = name;
    }
    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }

    // Metodo pubblico statico per ottenere l'unica istanza
    public static InvestitorePrivato getInstance(String name) {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
        instance = new InvestitorePrivato(name);
        }
        // Restituisce l'istanza esistente
        return instance;
    }
    // Metodo per stampare un messaggio
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Sono l'investitore privato " + this.getName() + " le mie azioni " + azione + " hanno prodotto come valore " + valore + " euro");
    }
    
}
//creo la classe investitore bancario come singleton
class InvestitoreBancario implements Investitore{
    // Istanza privata statica della classe
    private static InvestitoreBancario instance;
    private String name;
    private String bank;

    // Costruttore privato per impedire l'istanziazione diretta
    private InvestitoreBancario(String name, String bank) {
        this.name = name;
        this.bank = bank;
    }
    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }
    //getter
    public String getBank() {
        return bank;
    }
    //setter
    public void setBank(String bank) {
        this.bank = bank;
    }
    // Metodo pubblico statico per ottenere l'unica istanza
    public static InvestitoreBancario getInstance(String name, String bank) {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
        instance = new InvestitoreBancario(name, bank);
        }
        // Restituisce l'istanza esistente
        return instance;
    }
    // Metodo per stampare un messaggio
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Sono l'investitore Bancario " + this.getName() + " presso la banca " + this.getBank() + " le mie azioni " + azione + " hanno prodotto come valore " + valore + " euro");
    }
    
}
