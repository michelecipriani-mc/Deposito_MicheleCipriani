import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioClassi {
    public static void main(String[] args) {
        //inizializzo la variabile per la scelta nel menù
        int scelta;
        //dichiarazione dell'arraylist per i bankaccount
        ArrayList<BankAccount> accounts = new ArrayList<>();
        //dichiarazione dello scanner
        Scanner myScanner = new Scanner(System.in);

        //creazione di oggetti bankaccount 
        accounts.add(new BankAccount("Michele", "Michele123!"));
        accounts.add(new BankAccount("Nancy", "Nancy123!"));
        accounts.add(new BankAccount("Davide", "Davide123!"));
        accounts.add(new BankAccount("Luciana", "Luciana123!"));

        //output guida
        System.out.println("Insetrisci il nome del titolare del conto:");
        //inizializzo una variabile in cui storo il nome inserito in input
        String name = myScanner.nextLine();

        //output guida
        System.out.println("Insetrisci la password:");
        //inizializzo una variabile password in cui storo la password inserita in input
        String password = myScanner.nextLine();

        //creo un ciclo foreach per verificare quale account
        for (BankAccount account : accounts) {
            //verifico le condizioni per accedere 
            if (account.getAccountHolderName().equalsIgnoreCase(name) && account.getPassword().equals(password)) {
                //messaggio di benvenuto
                System.out.println("Benvenuto, sei nel menu, queste sono le operazioni disponibili!");
                //ciclo che mi permette di farci vedere il menù ed effettuare le varie scelte
                do {
                    System.out.println("Scegli operazione:\n1-Deposita\n2-Preleva\n3-Mostra saldo\n4-Esci dal menu");
                    scelta = myScanner.nextInt();
                    //verifichiamo attraverso un while che la scelta sia corretta
                    while (scelta <=0 && scelta > 4) {
                        System.out.println("Errore: Inserisci un numero valido per il menu: ");
                        scelta = myScanner.nextInt();
                    }

                    //switch per permettermi di gestire cosa fa il menù
                    switch (scelta) {
                        //caso deposito
                        case 1:
                            System.out.println("Inserisci importo da depositare: ");
                            double deposit = myScanner.nextInt();
                            account.deposit(deposit);
                            break;
                        //caso prelievo
                        case 2:
                            System.out.println("Inserisci importo da prelevare: ");
                            double withdraw = myScanner.nextInt();
                            account.withdraw(withdraw);
                            break;
                        //caso mostra bilancio conto
                        case 3:
                            account.displayBalance();
                            break;
                        //caso di uscita dal sistema
                        case 4:
                            System.out.println("Uscita dal sistema... ");
                            break;
                        default:
                            break;
                    }
                } while (scelta != 4); //verifica della condizione nel while
                break; //interrompo se trovo l'account corretto
            } else {
                //output in caso di credenziali errate
                System.out.println("Credenziali non valide. Accesso negato!");
            }
        }

        //chiusura scanner
        myScanner.close();
    }
}

class BankAccount {
    //dichiarazione attributo 
    private String accountHolderName;
    private String password;
    private double balance;

    //costruttore
    public BankAccount(String accountHolderName, String password) {
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = 0.0;
    }

    //getter
    public String getAccountHolderName() {
        return accountHolderName;
    }

    //getter
    public String getPassword() {
        return password;
    }

    //metodo di deposito
    public void deposit(double amount) {
        //verifica del bilancio e del ammontare
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposito di " + amount + " effettuato con successo!");
        } else {
            System.out.println("Importo non valido per il deposito");
        }
    }

    //metodo per il prelievo
    public void withdraw(double amount) {
        //verifica del bilancio e del ammontare
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Prelievo di " + amount + " effettuato con successo!");
        } else {
            System.out.println("Prelievo non consetito: fondi insufficienti o importo non valido!");
        }
    }

    //metodo per la stampa del saldo
    public void displayBalance() {
        System.out.println("Saldo attuale: " + balance + " euro");
    }

}
