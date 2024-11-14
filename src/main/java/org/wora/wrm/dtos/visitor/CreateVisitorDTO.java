package org.wora.wrm.dtos.visitor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.wora.wrm.entities.Visitor;
import org.wora.wrm.utils.annotations.uniqueField.UniqueField;

public record CreateVisitorDTO(

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

        @Size(
                max = 255,
                message = "Email must be less than 255 characters"
        )
        @UniqueField(
                entity = Visitor.class,
                fieldName = "email",
                message = "Visitor with this email already exists"
        )
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Phone is required")
        String phone,

        @Min(
                value = 18,
                message = "Age must be greater than 0"
        )
        @NotNull
        short age

) {
}
