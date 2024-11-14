package org.wora.wrm.dtos.waitingList;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.wora.wrm.entities.enums.AlgorithmType;
import org.wora.wrm.entities.enums.WorkMode;

import java.time.LocalDate;

public record CreateWaitingListDTO(

        @NotNull(message = "Date is required")
        @FutureOrPresent(message = "Date must be in the present or future")
        LocalDate date,

        @NotNull(message = "Algorithm type is required")
        AlgorithmType algorithmType,

        @NotNull(message = "Work mode is required")
        WorkMode workMode,

        @NotNull(message = "Capacity is required")
        @Min(
                value = 1,
                message = "Capacity must be equal or greater than 1"
        )
        int capacity

) {
}
