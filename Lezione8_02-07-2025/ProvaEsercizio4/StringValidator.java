package ProvaEsercizio4;

public class StringValidator {
    public static void check(String string) throws ShortString{
        if (string.length() < 8) {
            throw new ShortString("Il nome è minore di 8 caratteri", null);
        }
    }
}
