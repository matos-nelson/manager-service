package org.rent.circle.manager.api.resource;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.rent.circle.manager.api.dto.ManagerDto;
import org.rent.circle.manager.api.dto.SaveManagerInfoDto;
import org.rent.circle.manager.api.service.ManagerService;

@AllArgsConstructor
@Authenticated
@Path("/manager")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class ManagerResource {

    private final ManagerService managerService;
    private final JsonWebToken jwt;

    @POST
    @PermitAll
    public Long saveManagerInfo(@Valid SaveManagerInfoDto saveManagerInfo) {
        return managerService.saveInfo(saveManagerInfo);
    }

    @GET
    @Path("/profile")
    public ManagerDto getManagerProfile() {
        return managerService.getManagerInfo(jwt.getName());
    }
}