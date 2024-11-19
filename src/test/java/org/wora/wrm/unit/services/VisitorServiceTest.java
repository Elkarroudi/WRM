package org.wora.wrm.unit.services;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.wora.wrm.dtos.visitor.CreateVisitorDTO;
import org.wora.wrm.dtos.visitor.VisitorResponseDTO;
import org.wora.wrm.services.implementations.VisitorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AllArgsConstructor
public class VisitorServiceTest {

    private final VisitorService visitorService;

    @Test
    void findAll_shouldReturnAllVisitors() {

    }

    @Test
    void findById_shouldReturnVisitorById() {

    }

    @Test
    void findById_shouldThrowExceptionWhenVisitorNotFound() {

    }

    @Test
    void save_shouldSaveVisitor() {

    }

    @Test
    void save_shouldThrowExceptionWhenDataIsNotValid() {

    }


    @Test
    void update_shouldUpdateVisitor() {

    }

    @Test
    void update_shouldThrowExceptionWhenVisitorDoesExists() {

    }

    @Test
    void delete_shouldDeleteVisitor() {

    }

}
