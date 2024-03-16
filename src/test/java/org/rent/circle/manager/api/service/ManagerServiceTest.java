package org.rent.circle.manager.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.rent.circle.manager.api.dto.ManagerDto;
import org.rent.circle.manager.api.dto.SaveManagerInfoDto;
import org.rent.circle.manager.api.persistence.model.Manager;
import org.rent.circle.manager.api.persistence.repository.ManagerRepository;
import org.rent.circle.manager.api.service.mapper.ManagerMapper;

@QuarkusTest
public class ManagerServiceTest {

    @InjectMock
    ManagerMapper managerMapper;

    @InjectMock
    ManagerRepository managerRepository;

    @Inject
    ManagerService managerService;


    @Test
    public void saveInfo_WhenCalled_ShouldReturnId() {
        // Arrange
        SaveManagerInfoDto saveManagerInfoDto = SaveManagerInfoDto.builder()
            .addressId(1L)
            .userId("manager")
            .businessName("My Business")
            .email("manager@email.com")
            .phone("9891234567")
            .build();

        Manager manager = new Manager();
        manager.setId(100L);

        when(managerMapper.toModel(saveManagerInfoDto)).thenReturn(manager);

        // Act
        Long result = managerService.saveInfo(saveManagerInfoDto);

        // Assert
        assertEquals(manager.getId(), result);
    }

    @Test
    public void getManagerInfo_WhenCalled_ShouldReturnManager() {
        // Arrange
        String userId = "manager";
        Manager manager = new Manager();
        manager.setId(1L);
        manager.setUserId(userId);

        ManagerDto managerDto = ManagerDto.builder()
            .addressId(1L)
            .businessName("My Business")
            .email("myemail@email.com")
            .phone("1234567890")
            .build();

        when(managerRepository.findByUserId(userId)).thenReturn(manager);
        when(managerMapper.toDto(manager)).thenReturn(managerDto);

        // Act
        ManagerDto result = managerService.getManagerInfo(userId);

        // Assert
        assertNotNull(result);
        assertEquals(managerDto, result);
    }

    @Test
    public void getManagerInfo_WhenManagerIsNotFound_ShouldReturnNull() {
        // Arrange
        String userId = "manager";

        when(managerRepository.findByUserId(userId)).thenReturn(null);
        when(managerMapper.toDto(null)).thenReturn(null);

        // Act
        ManagerDto result = managerService.getManagerInfo(userId);

        // Assert
        assertNull(result);
    }
}
