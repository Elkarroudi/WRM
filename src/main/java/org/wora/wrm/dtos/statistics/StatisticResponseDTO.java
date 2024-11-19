package org.wora.wrm.dtos.statistics;

import java.time.LocalDate;

public record StatisticResponseDTO(

        LocalDate date,
        int totalVisits,
        int averageWaitingTime,
        int averageSpentTime

) {
}
