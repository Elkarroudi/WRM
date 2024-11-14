package org.wora.wrm.entities.mappers;

public interface IGenericMapper<Entity, EntityDTO, CreateDTO, UpdateDTO, ResponseDTO> {

    Entity toEntity(CreateDTO createEntityDTO);
    ResponseDTO toResponseDtoFromEntityWithRelationShips(Entity entity);

}
