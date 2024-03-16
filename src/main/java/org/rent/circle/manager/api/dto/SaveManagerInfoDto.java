package org.rent.circle.manager.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class SaveManagerInfoDto {

    @NotNull
    private Long addressId;

    @NotNull
    @NotBlank
    private String businessName;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String phone;
}
