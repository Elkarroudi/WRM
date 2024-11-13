package org.wora.wrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.wora.wrm.entities.enums.AlgorithmType;
import org.wora.wrm.entities.enums.WorkMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "waitingLists")
public class WaitingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            name = "date",
            unique = true,
            nullable = false
    )
    private LocalDate date;

    @Column(
            name = "algorithmType",
            updatable = false,
            nullable = false
    )
    private AlgorithmType algorithmType;

    @Column(
            name = "workMode",
            nullable = false
    )
    private WorkMode workMode;

    @Column(
            name = "capacity",
            nullable = false
    )
    private int capacity;


    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
