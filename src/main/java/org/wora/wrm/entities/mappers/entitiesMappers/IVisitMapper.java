package org.wora.wrm.entities.mappers.entitiesMappers;

import org.mapstruct.Mapper;
import org.wora.wrm.dtos.visit.CreateVisitDTO;
import org.wora.wrm.dtos.visit.UpdateVisitDTO;
import org.wora.wrm.dtos.visit.VisitDTO;
import org.wora.wrm.dtos.visit.VisitResponseDTO;
import org.wora.wrm.entities.Visit;
import org.wora.wrm.entities.mappers.IGenericMapper;

@Mapper(
        componentModel = "spring"
)
public interface IVisitMapper extends IGenericMapper<Visit, VisitDTO, CreateVisitDTO, UpdateVisitDTO, VisitResponseDTO> {
}
