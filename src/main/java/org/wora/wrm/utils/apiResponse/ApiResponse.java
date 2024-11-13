package org.wora.wrm.utils.apiResponse;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    @NotNull
    private int httpStatus;

    private final LocalDateTime timestamp = LocalDateTime.now();

}
