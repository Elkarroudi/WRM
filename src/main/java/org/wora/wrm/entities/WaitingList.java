package org.wora.wrm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.wora.wrm.entities.enums.AlgorithmType;
import org.wora.wrm.entities.enums.WorkMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "waitingLists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WaitingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            name = "date",
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

    @OneToMany(
            mappedBy = "waitingList",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<Visit> visits = new ArrayList<>();;


    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
