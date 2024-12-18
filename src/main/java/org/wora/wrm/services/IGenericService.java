package org.wora.wrm.services;

import org.springframework.data.domain.Page;

public interface IGenericService<Entity, CreateDTO, UpdateDTO, ResponseDTO> {

    Page<ResponseDTO> findAll(int page, int size);
    ResponseDTO findById(String id);
    ResponseDTO save(CreateDTO dto);
    ResponseDTO update(String id, UpdateDTO dto);
    void delete(String id);

    Entity getEntityById(String id);
}
