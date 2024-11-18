package org.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wora.wrm.entities.WaitingList;

@Repository
public interface IWaitingListRepository extends JpaRepository<WaitingList, String> {
}
