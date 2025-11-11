package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.dto.DestinationNotificationDTO;
import org.acme.dto.OriginNotificationDTO;
import org.acme.service.NotificationService;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/notifications")
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class NotificationController {

    private final NotificationService notificationService;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response postNotification(OriginNotificationDTO originNotificationDTO) {
        DestinationNotificationDTO destinationNotificationDTO = notificationService.processNotification(originNotificationDTO);
        return Response.status(Response.Status.CREATED)
                .entity(destinationNotificationDTO)
                .build();
    }
}
