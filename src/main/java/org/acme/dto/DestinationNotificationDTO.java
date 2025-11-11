package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.acme.inout.Channel;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationNotificationDTO {

    private String content;
    private Channel destinationChannel;
}
