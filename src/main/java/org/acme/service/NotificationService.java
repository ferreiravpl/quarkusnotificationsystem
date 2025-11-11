package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.acme.dto.DestinationNotificationDTO;
import org.acme.dto.OriginNotificationDTO;
import org.acme.producer.NotificationProducer;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class NotificationService {

    private final NotificationProducer notificationProducer;

    public DestinationNotificationDTO processNotification(OriginNotificationDTO originNotificationDTO) {
        try {
            DestinationNotificationDTO destinationNotificationDTO = convertOriginNotificationToDestination(originNotificationDTO);
            notificationProducer.sendNotification(destinationNotificationDTO);
            return destinationNotificationDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private DestinationNotificationDTO convertOriginNotificationToDestination(OriginNotificationDTO originNotificationDTO) {
        return DestinationNotificationDTO.builder()
                .content(originNotificationDTO.getContent())
                .destinationChannel(originNotificationDTO.getOriginChannel())
                .build();
    }
}
