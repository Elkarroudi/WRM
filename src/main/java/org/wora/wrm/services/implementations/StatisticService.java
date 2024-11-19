package org.wora.wrm.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.wora.wrm.dtos.statistics.StatisticResponseDTO;
import org.wora.wrm.entities.WaitingList;
import org.wora.wrm.services.contracts.IStatisticService;
import org.wora.wrm.services.contracts.IVisitorService;
import org.wora.wrm.services.contracts.IWaitingListService;

import java.time.Duration;

@Service
@AllArgsConstructor
public class StatisticService implements IStatisticService {

    private final IWaitingListService waitingListService;
    private final IVisitorService visitorService;


    @Override
    public StatisticResponseDTO getAverageStatisticByDay(String statisticId) {

        WaitingList waitingList = waitingListService.getEntityById(statisticId);
        int totalVisits = waitingList.getVisits().size();

        // Calculate the average time spent waiting and the average time spent
        int totalWaitingTime = waitingList.getVisits().stream()
                .filter(visit -> visit.getStartTime() != null && visit.getArrivalTime() != null) // Ensure valid times
                .mapToInt(visit -> Duration.between(visit.getArrivalTime(), visit.getStartTime()).toMinutesPart()) // Calculate waiting time
                .sum();

        int totalSpentTime = waitingList.getVisits().stream()
                .filter(visit -> visit.getStartTime() != null && visit.getEndTime() != null) // Ensure valid times
                .mapToInt(visit -> Duration.between(visit.getStartTime(), visit.getEndTime()).toMinutesPart()) // Calculate time spent
                .sum();


        int averageWaitingTime = totalVisits > 0 ? totalWaitingTime / totalVisits : 0;
        int averageSpentTime = totalVisits > 0 ? totalSpentTime / totalVisits : 0;

        return new StatisticResponseDTO(
                waitingList.getDate(),
                totalVisits,
                averageWaitingTime,
                averageSpentTime
        );

    }
}
