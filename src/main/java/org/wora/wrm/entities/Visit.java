package org.wora.wrm.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.wora.wrm.entities.embeddeds.EmbeddedVisitKey;
import org.wora.wrm.entities.enums.VisitStatus;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "visits")
public class Visit implements Serializable {

    @EmbeddedId
    private EmbeddedVisitKey id;

    @Column(
            name = "arrivalTime",
            nullable = false
    )
    private LocalTime arrivalTime;

    @Column( name = "startTime" )
    private LocalTime startTime;

    @Column( name = "endTime" )
    private LocalTime endTime;

    @Column(
            name = "status",
            nullable = false
    )
    private VisitStatus status;

    @Column(
            name = "priority",
            nullable = false
    )
    private byte priority;

    @Column(
            name = "estimatedProcessingTime",
            nullable = false
    )
    private Duration estimatedProcessingTime;

    @ManyToOne
    @MapsId("visitorId")
    @JoinColumn(name = "visitorId")
    private Visitor visitor;

    @ManyToOne
    @MapsId("waitingListId")
    @JoinColumn(name = "waitingListId")
    private WaitingList waitingListId;


    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
