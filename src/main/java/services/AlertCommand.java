package services;

import notification.Notification;
import notification.NotificationFactory;
import models.User;

import java.util.List;

public class AlertCommand {
    private String app;
    private List<User> users;

    public AlertCommand(String app, List<User> users) {
        this.app = app;
        this.users = users;
    }

    public void execute() {
        for (User user : users) {
           notify(user);
        }
    }

    private void notify(User user) {
        List<String> notificationTypes = user.getNotificationTypes();
        for (String type : notificationTypes) {
            Notification notification = new NotificationFactory().getInstance(type, user, app);
            notification.send();
        }
    }
}