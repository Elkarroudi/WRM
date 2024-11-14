package org.wora.wrm.dtos.waitingList;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.wora.wrm.dtos.visit.VisitDTO;
import org.wora.wrm.entities.WaitingList;
import org.wora.wrm.entities.enums.AlgorithmType;
import org.wora.wrm.entities.enums.WorkMode;
import org.wora.wrm.utils.annotations.exist.Exist;

import java.time.LocalDate;
import java.util.List;

public record WaitingListResponseDTO(

        @NotBlank(message = "Waiting list id is required")
        @Exist(
                entity = WaitingList.class,
                message = "Waiting list with this id does not exist"
        )
        String id,

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
        int capacity,


        List<VisitDTO> visits
) {
}
