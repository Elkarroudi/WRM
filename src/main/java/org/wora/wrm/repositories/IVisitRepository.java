package org.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.wrm.entities.Visit;
import org.wora.wrm.entities.embeddeds.EmbeddedVisitKey;

public interface IVisitRepository extends JpaRepository<Visit, EmbeddedVisitKey> {
}
