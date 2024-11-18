package org.wora.wrm.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.wora.wrm.dtos.visitor.CreateVisitorDTO;
import org.wora.wrm.dtos.visitor.UpdateVisitorDTO;
import org.wora.wrm.dtos.visitor.VisitorResponseDTO;
import org.wora.wrm.entities.Visitor;
import org.wora.wrm.entities.mappers.entitiesMappers.IVisitorMapper;
import org.wora.wrm.repositories.IVisitorRepository;
import org.wora.wrm.services.contracts.IVisitorService;
import org.wora.wrm.utils.exceptions.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class VisitorService implements IVisitorService {

    private final IVisitorRepository repository;
    private final IVisitorMapper mapper;


    @Override
    public Page<VisitorResponseDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Visitor> visitors = repository.findAll(pageable);

        return visitors.map(mapper::toResponseDtoFromEntityWithRelationShips);
    }

    @Override
    public VisitorResponseDTO findById(String id) {
        Visitor visitor = getEntityById(id);
        return mapper.toResponseDtoFromEntityWithRelationShips(visitor);
    }

    @Override
    public VisitorResponseDTO save(CreateVisitorDTO dto) {
        Visitor newVisitor = mapper.toEntity(dto);
        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(newVisitor)
        );
    }

    @Override
    public VisitorResponseDTO update(String id, UpdateVisitorDTO dto) {
        System.err.println(id);
        System.err.println(dto.id());
        Visitor visitorToUpdate = getEntityById(id);

        visitorToUpdate.setFirstName(dto.firstName());
        visitorToUpdate.setLastName(dto.lastName());
        visitorToUpdate.setEmail(dto.email());
        visitorToUpdate.setPhone(dto.phone());
        visitorToUpdate.setAge(dto.age());

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(visitorToUpdate)
        );
    }

    @Override
    public void delete(String id) {
        Visitor visitorToDelete = getEntityById(id);
        repository.delete(visitorToDelete);
    }

    @Override
    public Visitor getEntityById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found With Id: " + id));
    }

}
