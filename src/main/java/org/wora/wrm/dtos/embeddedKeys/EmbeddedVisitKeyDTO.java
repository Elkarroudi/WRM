package org.wora.wrm.dtos.embeddedKeys;

import jakarta.validation.constraints.NotBlank;
import org.wora.wrm.entities.Visitor;
import org.wora.wrm.entities.WaitingList;
import org.wora.wrm.utils.annotations.exist.Exist;

public record EmbeddedVisitKeyDTO(

        @NotBlank(message = "Visitor id is required")
        @Exist(
                entity = Visitor.class,
                message = "Visitor with this id does not exist"
        )
        String visitorId,

        @NotBlank(message = "Waiting list id is required")
        @Exist(
                entity = WaitingList.class,
                message = "Waiting list with this id does not exist"
        )
        String waitingListId

) {
}
