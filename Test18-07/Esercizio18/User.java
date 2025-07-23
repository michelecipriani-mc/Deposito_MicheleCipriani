public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void receiveNotification(Notification notification) {
        System.out.println("[" + username + "] Ricevuta notifica: " + notification.getFormattedMessage());
    }

    public String getUsername() {
        return username;
    }
}
