import java.util.Scanner;

public class Risposta5 {
    public static void main(String[] args) {
        //creo lo scanner
        Scanner myScannerStr = new Scanner(System.in);

        //faccio inserire i dati per la creazione del conto
        System.out.println("Inserisci numero conto:");
        String numConto = myScannerStr.nextLine();
        System.out.println("Inserisci titolare conto: ");
        String nome = myScannerStr.nextLine();

        //creo il conto
        ContoBancario conto = new ContoBancario(numConto, nome);

        //richiamo i metodi preleva e deposita
        conto.deposita(500);
        conto.preleva(800);

        //chiudo scanner
        myScannerStr.close();
    }
}

class ContoBancario {
    //attributi
    private String numeroConto;
    private double saldo;
    private String titolare;

    //costruttore
    public ContoBancario(String numeroConto, String titolare) {
        this.numeroConto = numeroConto;
        saldo = (double) (Math.random() * 10000);
        this.titolare = titolare;
    }

    //getter e setter
    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitolare() {
        return titolare;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    //metodo per depositare denaro
    public void deposita(double importo) {
        //effettuo una verifica se l'importo è maggiore di 0 allora condedo il deposito
        if (importo > 0) {
            saldo += importo;
            //altrimenti stampo importo non valido
        } else {
            System.out.println("Devi inserire un importo valido per il deposito!");
        }
    }

    //metodo per prelevare denaro
    public void preleva(double importo) {
        //effettuo una verifica se l'importo è maggiore di 0 e la disponibilità e superiore alla richiesta allora condedo il prelievo
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
            //altrimenti stampo saldo insufficiente
        } else {
            System.out.println("Saldo insufficiente!");
        }
    }

    
}