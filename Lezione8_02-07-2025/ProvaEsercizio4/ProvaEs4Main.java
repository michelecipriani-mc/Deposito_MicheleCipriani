package ProvaEsercizio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProvaEs4Main {
    public static void main(String[] args) {

        /* PROVA 1 */
        try {
            ProvaEccezione4.divisioneChecked(4, 2);
            try {
                ProvaEccezione4.divisioneUnchecked(4, 1);
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                System.out.println(message);
            }

            try {
                ProvaEccezione4.divisione(4, 0);
            } catch (Exception e) {
                String message = e.getMessage();
                System.out.println(message);
                Throwable causa = e.getCause();
                System.out.println(message + causa); 
                e.printStackTrace();
                causa.printStackTrace();               
            }
            System.out.println("Ciao");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Programma Terminato");

        /* PROVA 2 CATCH ANNIDATI */
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Inserisci un numero: ");
            int input = scanner.nextInt();
            System.out.println("Inserisci un numero: ");
            int dividendo = scanner.nextInt();
            int risultato = ProvaEccezione4.divisioneUnchecked(input, dividendo);
            System.out.println(risultato);
        } catch (InputMismatchException | ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* PROVA 3 CUSTOM */
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Inserisci nome: ");
            String input = scanner.nextLine();
            StringValidator.check(input);
            System.out.println("Nome corretto");
        } catch (ShortString e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}