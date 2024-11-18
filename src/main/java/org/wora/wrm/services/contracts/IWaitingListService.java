package org.wora.wrm.services.contracts;

import org.wora.wrm.dtos.waitingList.CreateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.UpdateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.WaitingListResponseDTO;
import org.wora.wrm.entities.WaitingList;
import org.wora.wrm.services.IGenericService;

public interface IWaitingListService extends IGenericService<WaitingList, CreateWaitingListDTO, UpdateWaitingListDTO, WaitingListResponseDTO> {
}
