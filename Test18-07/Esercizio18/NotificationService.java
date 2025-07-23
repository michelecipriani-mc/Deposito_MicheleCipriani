import java.util.ArrayList;

public class NotificationService {
    private static NotificationService instance;
    private ArrayList<User> utenti = new ArrayList<>();


    public NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void register(User user) {
        utenti.add(user);
        System.out.println("Utente registrato con successo!");
    }

    public void unRegister(User user) {
        utenti.remove(user);
        System.out.println("Utente cancellato con successo!");
    }

    public void sendNotification(Notification notification) {
        System.out.println("\nInvio notifica a tutti gli utenti...");
        for (User user : utenti) {
            user.receiveNotification(notification);
        }
    }

    
}
