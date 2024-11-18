package org.wora.wrm.controllers.v1;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wora.wrm.dtos.visitor.CreateVisitorDTO;
import org.wora.wrm.dtos.visitor.UpdateVisitorDTO;
import org.wora.wrm.dtos.visitor.VisitorResponseDTO;
import org.wora.wrm.services.contracts.IVisitorService;

@RequestMapping("/api/v1/visitor")
@RestController
@AllArgsConstructor
public class VisitorController {

    private final IVisitorService service;


    @GetMapping
    ResponseEntity<Page<VisitorResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<VisitorResponseDTO> visitors = service.findAll(page, size);
        return ResponseEntity.ok(visitors);
    }

    @GetMapping("/{id}")
    ResponseEntity<VisitorResponseDTO> findById(@PathVariable String id) {
        VisitorResponseDTO visitor = service.findById(id);
        return ResponseEntity.ok(visitor);
    }

    @PostMapping
    ResponseEntity<VisitorResponseDTO> save(@Valid @RequestBody CreateVisitorDTO dto) {
        VisitorResponseDTO visitor = service.save(dto);
        return ResponseEntity.ok(visitor);
    }

    @PutMapping("/{id}")
    ResponseEntity<VisitorResponseDTO> update(@PathVariable String id, @Valid @RequestBody UpdateVisitorDTO dto) {
        VisitorResponseDTO visitor = service.update(id, dto);
        return ResponseEntity.ok(visitor);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
