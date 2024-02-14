package br.com.marketplace.domain.dto.phone;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneCreateDto {

    @NotBlank
    private String phoneNumber;
}
