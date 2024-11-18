package org.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wora.wrm.entities.Visitor;

@Repository
public interface IVisitorRepository extends JpaRepository<Visitor, String> {
}
