package org.wora.wrm.dtos.visitor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VisitorDTO(

        @Size(
                max = 255,
                message = "First name must be less than 255 characters"
        )
        @NotBlank(message = "First name is required")
        String firstName,

        @Size(
                max = 255,
                message = "Last name must be less than 255 characters"
        )
        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Phone is required")
        String phone

) {
}
