package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.dto.OriginNotificationDTO;
import org.acme.producer.NotificationProducerService;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/notifications")
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class NotificationController {

    private final NotificationProducerService notificationService;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response postNotification(OriginNotificationDTO originNotificationDTO) {
        OriginNotificationDTO processedNotification = notificationService.processNotification(originNotificationDTO);
        return Response.status(Response.Status.CREATED)
                .entity(processedNotification)
                .build();
    }
}
