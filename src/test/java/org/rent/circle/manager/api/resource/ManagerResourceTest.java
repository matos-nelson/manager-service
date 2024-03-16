package org.rent.circle.manager.api.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.rent.circle.manager.api.annotation.AuthManager;
import org.rent.circle.manager.api.dto.SaveManagerInfoDto;

@QuarkusTest
@TestHTTPEndpoint(ManagerResource.class)
@QuarkusTestResource(H2DatabaseTestResource.class)
@AuthManager
public class ManagerResourceTest {

    @Test
    public void POST_WhenGivenAValidRequestToSave_ShouldReturnSavedId() {
        // Arrange
        SaveManagerInfoDto managerInfo = SaveManagerInfoDto.builder()
            .addressId(1L)
            .businessName("My Business")
            .userId("auth_manager")
            .email("myemail@email.com")
            .phone("1234567890")
            .build();

        // Act
        // Assert
        given()
            .contentType("application/json")
            .body(managerInfo)
            .when()
            .post()
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body(is("1"));
    }
}
