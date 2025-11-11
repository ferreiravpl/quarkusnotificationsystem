package org.acme.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.DestinationNotificationDTO;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class NotificationConsumer {

    @Incoming("notifications-in")
    public void consumeNotification(DestinationNotificationDTO notification) {
        System.out.println("Received notification: " + notification);
    }
}
