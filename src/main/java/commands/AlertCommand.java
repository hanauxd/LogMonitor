package commands;

import notification.Notification;
import notification.NotificationFactory;
import models.User;

import java.util.List;

public class AlertCommand implements Command {
    private String app;
    private List<User> users;
    private NotificationFactory notificationFactory;

    public AlertCommand(String app, List<User> users) {
        this.app = app;
        this.users = users;
        this.notificationFactory = new NotificationFactory();
    }

    @Override
    public void execute() {
        for (User user : users) {
            notify(user);
        }
    }

    private void notify(User user) {
        List<String> notificationTypes = user.getNotificationTypes();
        for (String type : notificationTypes) {
            Notification notification = notificationFactory.getInstance(type, user, app);
            notification.send();
        }
    }
}