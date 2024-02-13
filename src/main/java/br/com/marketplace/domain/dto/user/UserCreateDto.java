package br.com.marketplace.domain.dto.user;

import br.com.marketplace.domain.dto.address.AddressCreateDto;
import br.com.marketplace.domain.dto.phone.PhoneCreateDto;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserCreateDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Lob
    private byte[] profilePicture;

    private List<PhoneCreateDto> phones = new ArrayList<>();

    private List<AddressCreateDto> addresses = new ArrayList<>();
}
