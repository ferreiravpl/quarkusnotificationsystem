package org.acme.inout;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Channel {
    CELLPHONE("notifications-cellphone"),
    EMAIL("notifications-email"),
    WHATSAPP("notifications-whatsapp"),
    DEFAULT("notifications");

    private final String notificationTopic;
}
