package org.wora.wrm.services.algorithms;

import java.util.List;

public interface SortingAlgorithm<T> {

    List<T> sort(List<T> items);

}
