package org.rent.circle.manager.api.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.rent.circle.manager.api.dto.ManagerDto;
import org.rent.circle.manager.api.dto.SaveManagerInfoDto;
import org.rent.circle.manager.api.persistence.model.Manager;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface ManagerMapper {

    Manager toModel(SaveManagerInfoDto managerInfo);

    ManagerDto toDto(Manager manager);
}
