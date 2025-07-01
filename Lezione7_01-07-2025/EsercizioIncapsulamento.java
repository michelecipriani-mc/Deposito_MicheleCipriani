import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento {
    public static void main(String[] args) {
        //dichiaro l'ArrayList
        ArrayList<Studente> studenti = new ArrayList<>();
        //dichiaro variaili
        int risposta = 0;
        String nome;
        int voto;
        //dichiaro scanner
        Scanner myScanner = new Scanner(System.in);
        Scanner myScanner1 = new Scanner(System.in);


        do {
            //stampa menù
            System.out.println("1 - Inserisci studente e voto");
            System.out.println("2 - Modifica voto");
            System.out.println("3 - Ricerca studente");
            System.out.println("4 - Stampa lista studenti");
            System.out.println("5 - Esci");
            //valorizzo la variabile con l'input del cliente
            risposta = myScanner.nextInt();

            //switch per gestire le scelte
            switch (risposta) {
                //caso inserisci studente
                case 1:
                    //chiedo nome utente
                    System.out.println("Inserisci nome studente: ");
                    //valorizzo la variabile con l'input del cliente
                    nome = myScanner1.nextLine();
                    //chiedo voto
                    System.out.println("Inserisci voto: ");
                    //valorizzo la variabile con l'input del cliente
                    voto = myScanner.nextInt();
                    //creo il nuovo oggetto studente
                    Studente studente = new Studente(nome, voto);
                    //aggiungo lo studente creato alla lista studenti
                    studenti.add(studente);
                    System.out.println("Studente inserito correttamente!");
                    break;
                //caso cambio voto
                case 2:
                    //chiedo il nome dell'utente su cui fare la modifica del voto
                    System.out.println("Inserisci nome studente: ");
                    //valorizzo la variabile con l'input del cliente
                    nome = myScanner1.nextLine();
                    //ciclo l'array list
                    for (Studente s : studenti) {
                        //se trovo il nome dello studente
                        if (nome.equals(s.getNome())) {
                            //chiedo di inserire voto
                            System.out.println("Inserisci voto: ");
                            //valorizzo la variabile con l'input del cliente
                            voto = myScanner.nextInt();
                            //chiamo il metodo per settare il voto
                            s.setVoto(voto);
                        } else {
                            //altrimenti comunico di non aver trovato nessuno studente e interrompo il ciclo
                            System.out.println("Nessuno studente trovato!");
                            break;
                        }
                    }
                    break;
                //caso ricerca studente
                case 3:
                    //chiedo una parola chiave
                    System.out.println("Inserisci nome studente:");
                    //valorizzo la variabile con l'input del cliente
                    String keyword = myScanner1.nextLine();
                    //creo un avariabile booleana che mi indica se trovo o meno lo studente
                    boolean esito = false;
                    //ciclo gli studenti
                    for (Studente s : studenti) {
                        //verifico la presenza dello studente con la keyword
                        if (keyword.equals(s.getNome())) {
                            //lo restituisco attraverso il metodo di stampa
                            s.stampaInfo();
                            //cambio il valore e comunico di averlo trovato
                            esito = true;
                        }
                    }
                    //verifico l'esito della verifica
                    if (!esito) {
                        //stampo se non c'è nessuno studente con quella keyword
                        System.out.println("Nessuno studente trovato con la parola chiave: " + keyword);
                    }
                    break;
                //caso stampa lista studenti
                case 4:
                    //ciclo gli studenti
                    for (Studente s : studenti) {
                        //Stampo le info
                        s.stampaInfo();
                    }
                    break;
                default: 
                    if (risposta == 5) {
                        System.out.println("Arrivederci!"); //messaggio in caso le altre scelte selezionate non siano partite   
                    } else {
                        System.out.println("Errore: scelta non valida!");
                    }
                    break;
            }
        } while (risposta != 5); //condizione di uscita

        //chiusura scanner
        myScanner1.close();
        myScanner.close();
    }
}

//creo la classe studente
class Studente {

    
    //attributi id, nome e voto privato
    private static int id;
    private String nome;
    private int voto;
    //costruttore
    public Studente(String nome, int voto) {
        id = id++;
        this.setNome(nome);
        this.setVoto(voto);
    }

    //verifica voto
    private void verificaVoto(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;
        } else {
            System.out.println("Errore: Voto non valido!");
        }
    }
    //get nome
    public String getNome() {
        return nome;
    }
    //set nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    //get voto
    public int getVoto() {
        return voto;
    }
    //set voto
    public void setVoto(int voto) {
       this.verificaVoto(voto);
    }

    //metodo per visualizzare tutti gli studenti
    public void stampaInfo() {
        System.out.println("Nome studente: " + this.getNome() + ", Voto: " + this.getVoto());
    }
}
