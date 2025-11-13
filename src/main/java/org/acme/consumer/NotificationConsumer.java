package org.acme.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.dto.DestinationNotificationDTO;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class NotificationConsumer {

    private final NotificationConsumerService notificationConsumerService;

    @Incoming("notifications-in")
    public void consumeNotification(DestinationNotificationDTO notification) {
        log.info("Received notification {}, topic {}: ", notification.getContent(), notification.getDestinationTopic());
        notificationConsumerService.processConsume(notification);
    }
}
