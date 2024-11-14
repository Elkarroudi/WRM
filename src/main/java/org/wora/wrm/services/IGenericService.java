package org.wora.wrm.services;

import org.springframework.data.domain.Page;
import org.wora.wrm.utils.apiResponse.ApiResponse;

public interface IGenericService<CreateDTO, UpdateDTO, ResponseDTO> {

    Page<ResponseDTO> findAll(int page, int size);
    ResponseDTO findById(String id);
    ResponseDTO save(CreateDTO dto);
    ResponseDTO update(String id, UpdateDTO dto);
    ApiResponse delete(String id);

}
