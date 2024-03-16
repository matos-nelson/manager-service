package org.rent.circle.manager.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rent.circle.manager.api.dto.SaveManagerInfoDto;
import org.rent.circle.manager.api.persistence.model.Manager;
import org.rent.circle.manager.api.persistence.repository.ManagerRepository;
import org.rent.circle.manager.api.service.mapper.ManagerMapper;

@AllArgsConstructor
@ApplicationScoped
@Slf4j
public class ManagerService {

    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

    @Transactional
    public Long saveInfo(SaveManagerInfoDto managerInfo) {
        Manager manager = managerMapper.toModel(managerInfo);
        managerRepository.persist(manager);
        return manager.getId();
    }
}
