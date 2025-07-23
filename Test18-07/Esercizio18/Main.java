public class Main {
    public static void main(String[] args) {
        User u1 = new User("Michele");
        User u2 = new User("Nicla");
        User u3 = new User("Alessio");
        NotificationService service = NotificationService.getInstance();
        service.register(u1);
        service.register(u2);
        service.register(u3);
        Notification notificaEmail = NotificationFactory.createNotification("email", "Benvenuto al sistema!");
        Notification notificaPush = NotificationFactory.createNotification("push", "Hai un nuovo messaggio!");
        Notification notificaSms = NotificationFactory.createNotification("sms", "Il tuo codice è 123456");
        service.sendNotification(notificaEmail);
        service.sendNotification(notificaPush);
        service.sendNotification(notificaSms);
    }
}
