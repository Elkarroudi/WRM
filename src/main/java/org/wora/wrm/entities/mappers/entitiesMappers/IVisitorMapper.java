package org.wora.wrm.entities.mappers.entitiesMappers;

import org.mapstruct.Mapper;
import org.wora.wrm.dtos.visitor.CreateVisitorDTO;
import org.wora.wrm.dtos.visitor.UpdateVisitorDTO;
import org.wora.wrm.dtos.visitor.VisitorDTO;
import org.wora.wrm.dtos.visitor.VisitorResponseDTO;
import org.wora.wrm.entities.Visitor;
import org.wora.wrm.entities.mappers.IGenericMapper;

@Mapper(
        componentModel = "spring"
)
public interface IVisitorMapper extends IGenericMapper<Visitor, VisitorDTO, CreateVisitorDTO, UpdateVisitorDTO, VisitorResponseDTO> {
}
