package org.wora.wrm.controllers.v1;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wora.wrm.dtos.visit.CreateVisitDTO;
import org.wora.wrm.dtos.visit.UpdateVisitDTO;
import org.wora.wrm.dtos.visit.VisitResponseDTO;
import org.wora.wrm.services.contracts.IVisitService;

import java.util.List;

@RequestMapping("/api/v1/visit")
@RestController
@AllArgsConstructor
public class VisitController {

    private final IVisitService service;


    @GetMapping("/all/{waitingListId}")
    ResponseEntity<List<VisitResponseDTO>> findByWaitingList(@PathVariable  String waitingListId) {
        List<VisitResponseDTO> visits = service.findAllVisitsByWaitingListId(waitingListId);
        return ResponseEntity.ok(visits);
    }

    @GetMapping("/find/{visitorId}/{waitingListId}")
    ResponseEntity<VisitResponseDTO> findById(@PathVariable String visitorId, @PathVariable String waitingListId) {
        VisitResponseDTO visit = service.findById(visitorId, waitingListId);
        return ResponseEntity.ok(visit);
    }

    @PostMapping
    ResponseEntity<VisitResponseDTO> save(@Valid @RequestBody CreateVisitDTO dto) {
        VisitResponseDTO visit = service.save(dto);
        return ResponseEntity.ok(visit);
    }

    @PutMapping("/{visitorId}/{waitingListId}")
    ResponseEntity<VisitResponseDTO> update(@PathVariable String visitorId, @PathVariable String waitingListId, @Valid @RequestBody UpdateVisitDTO dto) {
        VisitResponseDTO visit = service.update(visitorId, waitingListId, dto);
        return ResponseEntity.ok(visit);
    }

    @DeleteMapping("/{visitorId}/{waitingListId}")
    ResponseEntity<Void> delete(@PathVariable String visitorId, @PathVariable String waitingListId) {
        service.delete(visitorId, waitingListId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/mark-in-progress/{visitorId}/{waitingListId}")
    ResponseEntity<VisitResponseDTO> markVisitInProgress(@PathVariable String visitorId, @PathVariable String waitingListId) {
        VisitResponseDTO visit = service.markVisitInProgress(visitorId, waitingListId);
        return ResponseEntity.ok(visit);
    }

    @PatchMapping("/complete/{visitorId}/{waitingListId}")
    ResponseEntity<VisitResponseDTO> markVisitCompleted(@PathVariable String visitorId, @PathVariable String waitingListId) {
        VisitResponseDTO visit = service.finishVisit(visitorId, waitingListId);
        return ResponseEntity.ok(visit);
    }

    @PatchMapping("/cancel/{visitorId}/{waitingListId}")
    ResponseEntity<VisitResponseDTO> markVisitCancelled(@PathVariable String visitorId, @PathVariable String waitingListId) {
        VisitResponseDTO visit = service.cancelVisit(visitorId, waitingListId);
        return ResponseEntity.ok(visit);
    }



}
