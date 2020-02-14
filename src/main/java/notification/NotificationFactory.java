package notification;

import models.User;

public class NotificationFactory {
    public Notification getInstance(String type, User user, String app) {
        Notification notification = null;
        switch (type) {
            case "email": notification = new EmailNotification(user.getEmail(), app); break;
            case "sms": notification = new SMSNotification(user.getPhone(), app); break;
            default:
                System.out.println("Invalid notification type."); break;
        }
        return notification;
    }
}