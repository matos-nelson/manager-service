package org.rent.circle.manager.api.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.rent.circle.manager.api.dto.ManagerDto;
import org.rent.circle.manager.api.dto.SaveManagerInfoDto;
import org.rent.circle.manager.api.persistence.model.Manager;

@QuarkusTest
public class ManagerMapperTest {

    @Inject
    ManagerMapper managerMapper;

    @Test
    public void toModel_WhenGivenNull_ShouldReturnNull() {
        // Arrange

        // Act
        Manager result = managerMapper.toModel(null);

        // Assert
        assertNull(result);
    }

    @Test
    public void toModel_WhenGivenManagerInfo_ShouldMap() {
        // Arranger
        SaveManagerInfoDto managerInfoDto = SaveManagerInfoDto.builder()
            .addressId(2L)
            .phone("1234567890")
            .email("manager@email.com")
            .businessName("My Business LLC")
            .build();

        // Act
        Manager result = managerMapper.toModel(managerInfoDto);

        // Assert
        assertEquals(managerInfoDto.getAddressId(), result.getAddressId());
        assertEquals(managerInfoDto.getPhone(), result.getPhone());
        assertEquals(managerInfoDto.getEmail(), result.getEmail());
        assertEquals(managerInfoDto.getBusinessName(), result.getBusinessName());
    }

    @Test
    public void toDto_WhenGivenNull_ShouldReturnNull() {
        // Arrange

        // Act
        ManagerDto result = managerMapper.toDto(null);

        // Assert
        assertNull(result);
    }

    @Test
    public void toDto_WhenGivenManager_ShouldMap() {
        // Arrange
        Manager manager = new Manager();
        manager.setId(1L);
        manager.setAddressId(2L);
        manager.setPhone("1234567890");
        manager.setEmail("manager@email.com");
        manager.setBusinessName("My Business");
        manager.setUserId("user_id");

        // Act
        ManagerDto result = managerMapper.toDto(manager);

        // Assert
        assertEquals(manager.getAddressId(), result.getAddressId());
        assertEquals(manager.getPhone(), result.getPhone());
        assertEquals(manager.getEmail(), result.getEmail());
        assertEquals(manager.getBusinessName(), result.getBusinessName());
        assertEquals(manager.getUserId(), result.getUserId());
    }
}
