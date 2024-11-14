package org.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.wrm.entities.WaitingList;

public interface IWaitingListRepository extends JpaRepository<WaitingList, String> {
}
