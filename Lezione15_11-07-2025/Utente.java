//classe user
public class Utente {
    private long id;
    private String userName;
    private String password;
    private static int contatore = 0;

    public Utente(String userName, String password) {
        this.setId(id);
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = contatore++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getContatore() {
        return contatore;
    }

    public static void setContatore(int contatore) {
        Utente.contatore = contatore;
    }
}
