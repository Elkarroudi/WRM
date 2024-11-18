package org.wora.wrm.services.contracts;

import org.wora.wrm.dtos.visit.CreateVisitDTO;
import org.wora.wrm.dtos.visit.UpdateVisitDTO;
import org.wora.wrm.dtos.visit.VisitResponseDTO;
import org.wora.wrm.entities.Visit;

import java.util.List;

public interface IVisitService {

    List<VisitResponseDTO> findAllVisitsByWaitingListId(String waitingListId);
    VisitResponseDTO findById(String visitorId, String waitingListId);
    VisitResponseDTO save(CreateVisitDTO dto);
    VisitResponseDTO update(String visitorId, String waitingListId, UpdateVisitDTO dto);
    VisitResponseDTO markVisitInProgress(String visitorId, String waitingListId);
    VisitResponseDTO finishVisit(String visitorId, String waitingListId);
    VisitResponseDTO cancelVisit(String visitorId, String waitingListId);
    void delete(String visitorId, String waitingListId);

    Visit getVisitById(String visitorId, String waitingListId);
    void setVisitorAndWaitingListIds(Visit visit, CreateVisitDTO dto);

}
