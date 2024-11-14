package org.wora.wrm.dtos.visit;

import jakarta.validation.constraints.NotNull;
import org.wora.wrm.dtos.embeddedKeys.EmbeddedVisitKeyDTO;
import org.wora.wrm.entities.enums.VisitStatus;

import java.time.LocalTime;

public record UpdateVisitDTO (

        EmbeddedVisitKeyDTO id,

        LocalTime startTime,
        LocalTime endTime,

        @NotNull(message = "Status is required")
        VisitStatus status

){
}
