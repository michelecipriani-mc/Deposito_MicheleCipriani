import java.util.Scanner;

public class ProvaEccezioni3 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Inserisci un numero: ");
            int input = scanner.nextInt();
            System.out.println("Input inserito: " + input);
            int x = input / 0;
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
