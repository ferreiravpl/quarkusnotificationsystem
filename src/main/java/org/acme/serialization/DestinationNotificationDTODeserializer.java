package org.acme.serialization;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.acme.dto.DestinationNotificationDTO;

public class DestinationNotificationDTODeserializer extends ObjectMapperDeserializer<DestinationNotificationDTO> {
    public DestinationNotificationDTODeserializer() {
        super(DestinationNotificationDTO.class);
    }
}

