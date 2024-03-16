package org.rent.circle.manager.api.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import rent.circle.rc.service.base.runtime.persistence.BaseModel;

@Entity
@Table(name = "manager")
@Setter
@Getter
public class Manager extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}
