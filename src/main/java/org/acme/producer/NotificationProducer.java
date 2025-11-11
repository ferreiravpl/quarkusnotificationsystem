package org.acme.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.acme.dto.DestinationNotificationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Slf4j
@ApplicationScoped
public class NotificationProducer {

    @Inject
    @Channel("notifications-out")
    private Emitter<DestinationNotificationDTO> emitter;

    public void sendNotification(DestinationNotificationDTO destinationNotificationDTO) {
        emitter.send(destinationNotificationDTO);
        log.info("Send notification: {}", destinationNotificationDTO.getContent());
    }
}
