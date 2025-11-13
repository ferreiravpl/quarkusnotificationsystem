package org.acme.producer;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.acme.dto.DestinationNotificationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@Slf4j
@ApplicationScoped
public class NotificationProducer {

    @Inject
    @Channel("notifications-out")
    private Emitter<DestinationNotificationDTO> emitter;

    public void sendNotification(DestinationNotificationDTO destinationNotificationDTO) {
        String topic = destinationNotificationDTO.getDestinationTopic(); // ex: "notifications-email"

        OutgoingKafkaRecordMetadata<Object> metadata =
                OutgoingKafkaRecordMetadata.<Object>builder()
                        .withTopic(topic)
                        .build();

        emitter.send(Message.of(destinationNotificationDTO).addMetadata(metadata));
        log.info("Send notification: {} to topic {}", destinationNotificationDTO.getContent(), destinationNotificationDTO.getDestinationTopic());
    }
}
