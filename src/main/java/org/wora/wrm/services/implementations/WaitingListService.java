package org.wora.wrm.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.wora.wrm.config.AppConfiguration;
import org.wora.wrm.dtos.waitingList.CreateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.UpdateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.WaitingListResponseDTO;
import org.wora.wrm.entities.WaitingList;
import org.wora.wrm.entities.mappers.entitiesMappers.IWaitingListMapper;
import org.wora.wrm.repositories.IWaitingListRepository;
import org.wora.wrm.services.contracts.IWaitingListService;
import org.wora.wrm.services.algorithms.implmentations.FifoAlgorithm;
import org.wora.wrm.services.algorithms.implmentations.HpfAlgorithm;
import org.wora.wrm.services.algorithms.implmentations.SjfAlgorithm;
import org.wora.wrm.utils.exceptions.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class WaitingListService implements IWaitingListService {

    private final IWaitingListRepository repository;
    private final IWaitingListMapper mapper;
    private AppConfiguration config;

    private FifoAlgorithm fifo;
    private HpfAlgorithm hpf;
    private SjfAlgorithm sjf;


    @Override
    public Page<WaitingListResponseDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<WaitingList> waitingLists = repository.findAll(pageable);

        return waitingLists.map(mapper::toResponseDtoFromEntityWithRelationShips);
    }

    @Override
    public WaitingListResponseDTO findById(String id) {
        WaitingList waitingList = getEntityById(id);

        return switch (waitingList.getAlgorithmType()) {
            case FIFO -> {
                waitingList.setVisits(
                        fifo.sort(waitingList.getVisits())
                );
                yield mapper.toResponseDtoFromEntityWithRelationShips(waitingList);
            }
            case SJF -> {
                waitingList.setVisits(
                        sjf.sort(waitingList.getVisits())
                );
                yield mapper.toResponseDtoFromEntityWithRelationShips(waitingList);
            }
            case HPF -> {
                waitingList.setVisits(
                        hpf.sort(waitingList.getVisits())
                );
                yield mapper.toResponseDtoFromEntityWithRelationShips(waitingList);
            }
        };

    }

    @Override
    public WaitingListResponseDTO save(CreateWaitingListDTO dto) {
        WaitingList newWaitingList = mapper.toEntity(dto);

        if (dto.algorithmType() == null) {
            newWaitingList.setAlgorithmType(config.getAlgorithmType());
        }

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(newWaitingList)
        );
    }

    @Override
    public WaitingListResponseDTO update(String id, UpdateWaitingListDTO dto) {
        WaitingList waitingListToUpdate = getEntityById(id);

        waitingListToUpdate.setWorkMode(dto.workMode());
        waitingListToUpdate.setCapacity(dto.capacity());

        return mapper.toResponseDtoFromEntityWithRelationShips(
                repository.save(waitingListToUpdate)
        );
    }

    @Override
    public void delete(String id) {
        WaitingList waitingListToDelete = getEntityById(id);
        repository.delete(waitingListToDelete);
    }

    @Override
    public WaitingList getEntityById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waiting List not found With Id: " + id));
    }

}
