package org.acme.service;

import org.acme.dto.DestinationNotificationDTO;

public interface NotificationProcessor {

    boolean acceptNotificationType(DestinationNotificationDTO destinationNotificationDTO);
    void processNotification(DestinationNotificationDTO destinationNotificationDTO);
}
