package org.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wora.wrm.entities.Visit;

public interface IVisitorRepository extends JpaRepository<Visit, String> {
}
