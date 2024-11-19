package org.wora.wrm.services.contracts;

import org.wora.wrm.dtos.statistics.StatisticResponseDTO;

public interface IStatisticService {

    StatisticResponseDTO getAverageStatisticByDay(String statisticId);

}
