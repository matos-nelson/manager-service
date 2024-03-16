package org.rent.circle.manager.api.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.rent.circle.manager.api.persistence.model.Manager;

@ApplicationScoped
public class ManagerRepository implements PanacheRepository<Manager> {

    public Manager findByUserId(String userId) {
        return find("userId", userId).firstResult();
    }
}
