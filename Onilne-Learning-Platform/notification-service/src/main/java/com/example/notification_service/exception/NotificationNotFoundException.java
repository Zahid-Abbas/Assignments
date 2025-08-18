package com.example.notification_service.exception;

public class NotificationNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotificationNotFoundException(String message) {
        super(message);
    }
}
