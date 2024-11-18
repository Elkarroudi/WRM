package org.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wora.wrm.entities.Visit;
import org.wora.wrm.entities.embeddeds.EmbeddedVisitKey;

import java.util.List;

@Repository
public interface IVisitRepository extends JpaRepository<Visit, EmbeddedVisitKey> {

    List<Visit> findAllByWaitingListId(String waitingListId);

}
