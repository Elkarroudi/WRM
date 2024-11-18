package org.wora.wrm.services.contracts;

import org.wora.wrm.dtos.visitor.CreateVisitorDTO;
import org.wora.wrm.dtos.visitor.UpdateVisitorDTO;
import org.wora.wrm.dtos.visitor.VisitorResponseDTO;
import org.wora.wrm.entities.Visitor;
import org.wora.wrm.services.IGenericService;

public interface IVisitorService extends IGenericService<Visitor, CreateVisitorDTO, UpdateVisitorDTO, VisitorResponseDTO> {
}
