package notification;

public class EmailNotification implements Notification {
    private String email;
    private String app;

    public EmailNotification(String email, String app) {
        this.email = email;
        this.app = app;
    }

    @Override
    public void send() {
        System.out.println("Sending Email notification from [" + app + "] to [" + email + "].");
    }
}