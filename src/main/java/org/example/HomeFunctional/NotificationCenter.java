package org.example.HomeFunctional;

public class NotificationCenter implements Observer {
    @Override
    public void update(String message) {
        System.out.println("USER ALERT" + message);
    }
}
