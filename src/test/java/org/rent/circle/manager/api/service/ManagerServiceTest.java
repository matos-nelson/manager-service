package org.rent.circle.manager.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
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
}
