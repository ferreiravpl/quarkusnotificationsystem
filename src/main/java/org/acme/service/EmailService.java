package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.acme.dto.DestinationNotificationDTO;

@Slf4j
@ApplicationScoped
public class EmailService implements NotificationProcessor {

    @Override
    public boolean acceptNotificationType(DestinationNotificationDTO destinationNotificationDTO) {
        return "notifications-email".equals(destinationNotificationDTO.getDestinationTopic());
    }

    @Override
    public void processNotification(DestinationNotificationDTO destinationNotificationDTO) {
        log.info("Processando notificação para email: {}", destinationNotificationDTO.getContent());
    }
}
