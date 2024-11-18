package org.wora.wrm.entities.mappers;

public interface IGenericMapper<Entity, EntityDTO, CreateDTO, UpdateDTO, ResponseDTO> {

    Entity toEntity(CreateDTO createEntityDTO);
    Entity toEntityFromResponseDto(ResponseDTO responseDTO);
    ResponseDTO toResponseDtoFromEntityWithRelationShips(Entity entity);
}
