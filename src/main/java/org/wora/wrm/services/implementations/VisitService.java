package org.wora.wrm.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.wora.wrm.dtos.visit.CreateVisitDTO;
import org.wora.wrm.dtos.visit.UpdateVisitDTO;
import org.wora.wrm.dtos.visit.VisitResponseDTO;
import org.wora.wrm.entities.Visit;
import org.wora.wrm.entities.embeddeds.EmbeddedVisitKey;
import org.wora.wrm.entities.enums.VisitStatus;
import org.wora.wrm.entities.mappers.entitiesMappers.IVisitMapper;
import org.wora.wrm.entities.mappers.entitiesMappers.IVisitorMapper;
import org.wora.wrm.entities.mappers.entitiesMappers.IWaitingListMapper;
import org.wora.wrm.repositories.IVisitRepository;
import org.wora.wrm.services.contracts.IVisitService;
import org.wora.wrm.services.contracts.IVisitorService;
import org.wora.wrm.services.contracts.IWaitingListService;
import org.wora.wrm.utils.exceptions.ResourceNotFoundException;

import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitService implements IVisitService {

    private IVisitRepository repository;
    private IVisitMapper mapper;

    private IVisitorService visitorService;
    private IVisitorMapper visitorMapper;

    private IWaitingListMapper waitingListMapper;
    private IWaitingListService waitingListService;


    @Override
    public List<VisitResponseDTO> findAllVisitsByWaitingListId(String waitingListId) {
        waitingListService.findById(waitingListId);
        List<VisitResponseDTO> visits = repository.findAllByWaitingListId(waitingListId)
                .stream()
                .map(mapper::toResponseDtoFromEntityWithRelationShips)
                .toList();

        return visits;
    }

    @Override
    public VisitResponseDTO findById(String visitorId, String waitingListId) {
        Visit visit = getVisitById(visitorId, waitingListId);
        return mapper.toResponseDtoFromEntityWithRelationShips(visit);
    }

    @Override
    public VisitResponseDTO save(CreateVisitDTO dto) {
        Visit newVisit = mapper.toEntity(dto);
        newVisit.setArrivalTime(LocalTime.now());

        setVisitorAndWaitingListIds(newVisit, dto);
        newVisit.setStatus(VisitStatus.WAITING);

        Visit savedVisit = repository.save(newVisit);
        return mapper.toResponseDtoFromEntityWithRelationShips( savedVisit);
    }

    @Override
    public VisitResponseDTO update(String visitorId, String waitingListId, UpdateVisitDTO dto) {
        Visit visit = getVisitById(visitorId, waitingListId);

        visit.setArrivalTime(dto.arrivalTime());
        visit.setPriority(dto.priority());
        visit.setEstimatedProcessingTime(dto.estimatedProcessingTime());

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(visit)
        );
    }

    @Override
    public VisitResponseDTO markVisitInProgress(String visitorId, String waitingListId) {
        Visit visit = getVisitById(visitorId, waitingListId);

        visit.setStatus(VisitStatus.IN_PROGRESS);
        visit.setStartTime(LocalTime.now());

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(visit)
        );
    }

    @Override
    public VisitResponseDTO finishVisit(String visitorId, String waitingListId) {
        Visit visit = getVisitById(visitorId, waitingListId);

        visit.setStatus(VisitStatus.FINISHED);
        visit.setEndTime(LocalTime.now());

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(visit)
        );
    }

    @Override
    public VisitResponseDTO cancelVisit(String visitorId, String waitingListId) {
        Visit visit = getVisitById(visitorId, waitingListId);

        visit.setStatus(VisitStatus.CANCELED);

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(visit)
        );
    }

    @Override
    public void delete(String visitorId, String waitingListId) {
        Visit visit = getVisitById(visitorId, waitingListId);
        repository.delete(visit);
    }

    @Override
    public Visit getVisitById(String visitorId, String waitingListId) {
        EmbeddedVisitKey key = new EmbeddedVisitKey(visitorId, waitingListId);
        return repository.findById(key)
                .orElseThrow(() -> new ResourceNotFoundException("Visit not found With Visitor Id: " + visitorId + " and Waiting List Id: " + waitingListId));
    }

    @Override
    public void setVisitorAndWaitingListIds(Visit visit, CreateVisitDTO dto) {

        visit.setVisitor(
                visitorMapper.toEntityFromResponseDto(
                        visitorService.findById(dto.id().visitorId())
                )
        );

        visit.setWaitingList(
                waitingListMapper.toEntityFromResponseDto(
                        waitingListService.findById(dto.id().waitingListId())
                )
        );

    }

}
