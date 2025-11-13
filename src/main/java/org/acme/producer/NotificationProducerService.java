package org.acme.producer;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.acme.dto.DestinationNotificationDTO;
import org.acme.dto.OriginNotificationDTO;
import org.acme.inout.Channel;

import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class NotificationProducerService {

    private final NotificationProducer notificationProducer;

    public OriginNotificationDTO processNotification(OriginNotificationDTO originNotificationDTO) {
        try {
            DestinationNotificationDTO destinationNotificationDTO = convertOriginNotificationToKafkaMessage(originNotificationDTO);
            notificationProducer.sendNotification(destinationNotificationDTO);
            return originNotificationDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private DestinationNotificationDTO convertOriginNotificationToKafkaMessage(OriginNotificationDTO originNotificationDTO) {
        String topic = getNotificationTopic(originNotificationDTO);
        return DestinationNotificationDTO.builder()
                .content(originNotificationDTO.getContent())
                .destinationTopic(topic)
                .build();
    }

    private String getNotificationTopic(OriginNotificationDTO originNotificationDTO) {
        return Optional.ofNullable(originNotificationDTO.getOriginChannel())
                .map(Channel::getNotificationTopic)
                .orElse("notifications");
    }
}
