package notification;

public class SMSNotification implements Notification {
    private String phone;
    private String app;

    public SMSNotification(String phone, String app) {
        this.phone = phone;
        this.app = app;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS notification from [" + app + "] to [" + phone + "].");
    }
}