package org.rent.circle.manager.api.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.rent.circle.manager.api.persistence.model.Manager;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ManagerRepositoryTest {

    @Inject
    ManagerRepository managerRepository;

    @Test
    @TestTransaction
    public void findByUserId_WhenManagerDoesNotExist_ShouldReturnNull() {
        // Arrange

        // Act
        Manager result = managerRepository.findByUserId("adasfs");

        // Assert
        assertNull(result);
    }

    @Test
    @TestTransaction
    public void findByUserId_WhenManagerDoesExist_ShouldReturnRecord() {
        // Arrange

        // Act
        Manager result = managerRepository.findByUserId("auth_manager");

        // Assert
        assertNotNull(result);
    }
}
