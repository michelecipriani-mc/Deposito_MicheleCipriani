public abstract class Notification {
    protected String message;

    public Notification(String message) {
        this.message = message;
    }

    public abstract String getFormattedMessage();
}

class EmailNotification extends Notification {
    public EmailNotification(String message) {
        super(message);
    }

    @Override
    public String getFormattedMessage() {
        return "[EMAIL] " + message;
    }
}

class SmsNotification extends Notification {
    public SmsNotification(String message) {
        super(message);
    }

    @Override
    public String getFormattedMessage() {
        return "[SMS] " + message;
    }
}

class PushNotification extends Notification {
    public PushNotification(String message) {
        super(message);
    }

    @Override
    public String getFormattedMessage() {
        return "[PUSH] " + message;
    }
}