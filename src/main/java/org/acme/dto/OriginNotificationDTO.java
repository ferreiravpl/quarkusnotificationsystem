package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.acme.inout.Channel;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // adicionada para Jackson
public class OriginNotificationDTO {

    private String content;
    private Channel originChannel;
}
