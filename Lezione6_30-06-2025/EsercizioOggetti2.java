import java.util.Scanner;

public class EsercizioOggetti2 {
    public static void main(String[] args) {

        //dichiaro uno scanner
        Scanner myScanner = new Scanner(System.in);
        
        //dichiaro 2 nuovi oggetti di tipo persona
        for (int i = 0; i < 2; i++) {
            System.out.println("inserisci il nome della persona:");
            String nome = myScanner.nextLine();
            System.out.println("Inserisci città");
            String città = myScanner.nextLine();
            Persona people = new Persona(nome, città);
            people.mostraInfo();
        }
        //chiudo lo scanner
        myScanner.close();
    }
}

class Persona {
    //dichiarazioni variabili
    String nome;
    String città;
    int età;

    //costrruttore
    public Persona(String nome, String città) {
        this.nome = nome;
        this.città = città;
        età = 27;
    }

    //metodo per la stampa
    void mostraInfo() {
        System.out.println("Nome: " + nome + " Città: " + città + " Età: " + età);
    }

    
}