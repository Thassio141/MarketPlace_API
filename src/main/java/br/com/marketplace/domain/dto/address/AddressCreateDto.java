package br.com.marketplace.domain.dto.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressCreateDto {

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String street;

    private String complement;

    @NotBlank
    private String cep;
}
