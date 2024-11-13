package org.wora.wrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            name = "firstName",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "lastName",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            unique = true,
            nullable = false
    )
    private String email;

    @Column(
            name = "phone",
            nullable = false
    )
    private String phone;

    @Column(
            name = "age",
            nullable = false
    )
    private short age;

    @CreationTimestamp
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
