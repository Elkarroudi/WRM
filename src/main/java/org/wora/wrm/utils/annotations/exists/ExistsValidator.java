package org.wora.wrm.utils.annotations.exists;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistsValidator implements ConstraintValidator<Exist, String> {

    private final static String FIELD_NAME = "id";
    private EntityManager entityManager;
    private Class<?> entity;

    @Override
    public void initialize(Exist constraintAnnotation) {
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext context) {
        if (id == null || id.isEmpty()) {
            return false;
        }

        String queryStr = String.format(
                "SELECT COUNT(e) FROM %s e WHERE e.%s = :id",
                entity.getSimpleName(), FIELD_NAME
        );

        Long count = entityManager.createQuery(queryStr, Long.class)
                .setParameter("id", id)
                .getSingleResult();

        return count > 0;
    }

}