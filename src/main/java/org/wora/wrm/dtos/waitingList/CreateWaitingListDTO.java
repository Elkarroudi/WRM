package org.wora.wrm.dtos.waitingList;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.wora.wrm.entities.enums.AlgorithmType;
import org.wora.wrm.entities.enums.WorkMode;

import java.time.LocalDate;

public record CreateWaitingListDTO(

        @NotNull(message = "Date is required")
        @FutureOrPresent(message = "Date must be in the present or future")
        LocalDate date,

        AlgorithmType algorithmType,

        @NotNull(message = "Work mode is required")
        WorkMode workMode,

        @Positive(message = "The point capacity must be greater than zero")
        int capacity

) {
}
