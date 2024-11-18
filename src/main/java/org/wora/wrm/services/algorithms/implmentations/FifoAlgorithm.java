package org.wora.wrm.services.algorithms.implmentations;

import org.springframework.stereotype.Component;
import org.wora.wrm.services.algorithms.SortingAlgorithm;
import org.wora.wrm.entities.Visit;

import java.util.Comparator;
import java.util.List;

@Component
public class FifoAlgorithm implements SortingAlgorithm<Visit> {

    @Override
    public List<Visit> sort(List<Visit> items) {
        return items.stream()
                .sorted(Comparator.comparing(Visit::getCreatedAt))
                .toList();
    }

}
