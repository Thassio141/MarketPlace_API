package br.com.marketplace.domain.dto.user;

import br.com.marketplace.domain.dto.address.AddressCreateDto;
import br.com.marketplace.domain.dto.phone.PhoneCreateDto;
import br.com.marketplace.domain.entity.*;
import br.com.marketplace.domain.enumeration.ActivityStatus;
import br.com.marketplace.domain.enumeration.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private ActivityStatus userStatus;

    private byte[] profilePicture;

    private List<PhoneCreateDto> phones = new ArrayList<>();

    private List<AddressCreateDto> addresses = new ArrayList<>();

    private List<Review> reviews = new ArrayList<>();

    private List<Product> products = new ArrayList<>();

    private ShopCart shopCart;
}
