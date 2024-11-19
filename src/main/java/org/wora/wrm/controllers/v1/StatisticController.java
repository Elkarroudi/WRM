package org.wora.wrm.controllers.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wora.wrm.dtos.statistics.StatisticResponseDTO;
import org.wora.wrm.services.contracts.IStatisticService;

@RestController
@RequestMapping("/api/v1/statistic")
@AllArgsConstructor
public class StatisticController {

    private final IStatisticService statisticService;

    @GetMapping("/{statisticId}")
    public ResponseEntity<StatisticResponseDTO> getAverageStatisticByDay(@PathVariable String statisticId) {
        StatisticResponseDTO dto = statisticService.getAverageStatisticByDay(statisticId);
        return ResponseEntity.ok(dto);
    }

}
