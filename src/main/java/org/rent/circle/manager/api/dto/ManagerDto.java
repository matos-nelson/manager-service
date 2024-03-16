package org.rent.circle.manager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {

    private Long addressId;
    private String businessName;
    private String userId;
    private String email;
    private String phone;
}
