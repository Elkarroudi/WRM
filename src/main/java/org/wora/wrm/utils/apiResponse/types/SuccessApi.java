package org.wora.wrm.utils.apiResponse.types;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.wora.wrm.utils.apiResponse.ApiResponse;

@Getter
public class SuccessApi<ResponseDTO> extends ApiResponse {

    private final boolean success = true;

    @NotBlank
    private final String path;

    @NotNull
    private ResponseDTO data;

    public SuccessApi(int httpStatus, String path, ResponseDTO data) {
        super(httpStatus);
        this.path = path;
        this.data = data;
    }

}
