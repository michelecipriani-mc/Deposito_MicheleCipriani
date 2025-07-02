public class ProvaEccezioni {
    public static void main(String[] args) {
        try {
            int x = 5;
            int y = 0;
            int z = x / y;
            System.out.println(z);
        } catch (Exception e) {
            e.printStackTrace();
            int a = 3 / 0;
            System.out.println(a);
        } finally {
            System.out.println("Finally");
        }
        System.out.println("Programma terminato");
    }
}