import java.util.Scanner;

public class Risposta5 {
    public static void main(String[] args) {
        Scanner myScannerStr = new Scanner(System.in);

        System.out.println("Inserisci numero conto:");
        String numConto = myScannerStr.nextLine();
        System.out.println("Inserisci titolare conto: ");
        String nome = myScannerStr.nextLine();

        ContoBancario conto = new ContoBancario(numConto, nome);

        conto.deposita(500);
        conto.preleva(800);

        myScannerStr.close();
    }
}

class ContoBancario {
    private String numeroConto;
    private double saldo;
    private String titolare;

    public ContoBancario(String numeroConto, String titolare) {
        this.numeroConto = numeroConto;
        saldo = (double) (Math.random() * 10000);
        this.titolare = titolare;
    }

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

    public void deposita(double importo) {
        if (importo > 0) {
            saldo += importo;
        } else {
            System.out.println("Devi inserire un importo valido per il deposito!");
        }
    }

    public void preleva(double importo) {
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
        } else {
            System.out.println("Saldo insufficiente!");
        }
    }

    
}