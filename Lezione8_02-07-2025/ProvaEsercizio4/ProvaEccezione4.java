package ProvaEsercizio4;

public class ProvaEccezione4 {
    public static int divisioneChecked(int a, int b) throws Exception{
        if (b == 0) {
            throw new Exception();
        }
        return a / b;
    }

    public static int divisioneUnchecked(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Il dividendo non può essere 0");
        }
        return a / b;
    }

    public static int divisione(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            throw new RuntimeException("Il dividendo non può essere 0", e);
        }
    }

    
}
