package org.acme.consumer;

import io.quarkus.arc.All;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.DestinationNotificationDTO;
import org.acme.service.NotificationProcessor;

import java.util.List;

@ApplicationScoped
public class NotificationConsumerService {

    @All
    @Inject
    List<NotificationProcessor> processors;

    public void processConsume(DestinationNotificationDTO notificationDTO) {
        processors.stream()
                .filter(processor -> processor.acceptNotificationType(notificationDTO))
                .findFirst()
                .ifPresent(pro -> pro.processNotification(notificationDTO));
    }

}
