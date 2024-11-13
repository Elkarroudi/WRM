package org.wora.wrm.utils.apiResponse.types;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.wora.wrm.utils.apiResponse.ApiResponse;

import java.util.Map;

@Getter
public class ErrorApi extends ApiResponse {

    private final boolean success = false;

    @NotNull
    private Map<String, Object> errors;

    public ErrorApi(int httpStatus, Map<String, Object> errors) {
        super(httpStatus);
        this.errors = errors;
    }

}
