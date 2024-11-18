package org.wora.wrm.dtos.visit;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.wora.wrm.dtos.embeddedKeys.EmbeddedVisitKeyDTO;

import java.time.Duration;

public record CreateVisitDTO(

        @NotNull(message = "id object is required")
        @Valid
        EmbeddedVisitKeyDTO id,

        @NotNull(message = "Priority is required")
        @Max(
                value = 255,
                message = "Priority must be between 1 and 255"
        )
        @Min(
                value = 0,
                message = "Priority must be between 1 and 255"
        )
        byte priority,

        @NotNull(message = "Estimated processing time is required")
        Duration estimatedProcessingTime

) {
}
