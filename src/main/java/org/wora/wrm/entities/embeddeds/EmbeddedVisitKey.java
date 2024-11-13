package org.wora.wrm.entities.embeddeds;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedVisitKey implements Serializable {

    @Column(
            name = "visitorId",
            updatable = false,
            nullable = false
    )
    private String visitorId;

    @Column(
            name = "waitingListId",
            updatable = false,
            nullable = false
    )
    private String waitingListId;

}
