package com.example.notification_service.service;

import java.util.List;
import com.example.notification_service.entity.Notification;

public interface NotificationService {
    Notification sendNotification(Notification notification);
    List<Notification> getAllNotifications();
    Notification getNotificationById(Long id);
    void deleteNotification(Long id);
}
