package org.wora.wrm.entities.mappers.entitiesMappers;

import org.mapstruct.Mapper;
import org.wora.wrm.dtos.waitingList.CreateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.UpdateWaitingListDTO;
import org.wora.wrm.dtos.waitingList.WaitingListDTO;
import org.wora.wrm.dtos.waitingList.WaitingListResponseDTO;
import org.wora.wrm.entities.WaitingList;
import org.wora.wrm.entities.mappers.IGenericMapper;

@Mapper(
        componentModel = "spring"
)
public interface IWaitingListMapper extends IGenericMapper<WaitingList, WaitingListDTO, CreateWaitingListDTO, UpdateWaitingListDTO, WaitingListResponseDTO> {
}
