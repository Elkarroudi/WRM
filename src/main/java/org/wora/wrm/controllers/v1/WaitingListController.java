package org.wora.wrm.controllers.v1;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wora.wrm.dtos.waitingList.CreateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.UpdateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.WaitingListResponseDTO;
import org.wora.wrm.services.contracts.IWaitingListService;

@RestController
@RequestMapping("/api/v1/waiting-list")
@AllArgsConstructor
public class WaitingListController {

    private final IWaitingListService service;


    @GetMapping
    ResponseEntity<Page<WaitingListResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<WaitingListResponseDTO> waitingLists = service.findAll(page, size);
        return ResponseEntity.ok(waitingLists);
    }

    @GetMapping("/{id}")
    ResponseEntity<WaitingListResponseDTO> findById(@PathVariable String id) {
        WaitingListResponseDTO visitor = service.findById(id);
        return ResponseEntity.ok(visitor);
    }

    @PostMapping
    ResponseEntity<WaitingListResponseDTO> save(@Valid @RequestBody CreateWaitingListDTO dto) {
        WaitingListResponseDTO visitor = service.save(dto);
        return ResponseEntity.ok(visitor);
    }

    @PutMapping("/{id}")
    ResponseEntity<WaitingListResponseDTO> update(@PathVariable String id, @Valid @RequestBody UpdateWaitingListDTO dto) {
        WaitingListResponseDTO visitor = service.update(id, dto);
        return ResponseEntity.ok(visitor);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
