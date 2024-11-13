package org.wora.wrm.utils.annotations.uniqueField;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

    private final EntityManager entityManager;
    private Class<?> entity;
    private String fieldName;

    @Override
    public void initialize(UniqueField constraintAnnotation) {
        entity = constraintAnnotation.entity();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        String queryStr = String.format(
                "SELECT COUNT(e) FROM %s e WHERE e.%s = :value",
                entity.getSimpleName(), fieldName
        );

        Long count = entityManager.createQuery(queryStr, Long.class)
                .setParameter("value", value)
                .getSingleResult();

        return count == 0;
    }

}
