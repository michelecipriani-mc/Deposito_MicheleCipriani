public class NotificationFactory {
    public static Notification createNotification(String type, String message) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification(message);
            case "sms":
                return new SmsNotification(message);
            case "push":
                return new PushNotification(message);
            default:
                throw new IllegalArgumentException("Tipo di notifica non supportato: " + type);
        }
    }
}
