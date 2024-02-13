package br.com.marketplace.services;

import br.com.marketplace.domain.dto.address.AddressCreateDto;
import br.com.marketplace.domain.dto.phone.PhoneCreateDto;
import br.com.marketplace.domain.dto.user.UserCreateDto;
import br.com.marketplace.domain.dto.user.UserDto;
import br.com.marketplace.domain.entity.Address;
import br.com.marketplace.domain.entity.Phone;
import br.com.marketplace.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperService {

    public UserDto mapUserEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setUserStatus(user.getUserStatus());
        userDto.setProfilePicture(user.getProfilePicture());

        List<PhoneCreateDto> phoneCreateDtos = user.getPhones().stream()
                .map(this::mapPhoneEntityToCreateDto)
                .toList();

        userDto.setPhones(phoneCreateDtos);

        List<AddressCreateDto> addressCreateDtos = user.getAddresses().stream()
                .map(this::mapAddressEntityToCreateDto)
                .toList();

        userDto.setAddresses(addressCreateDtos);

        userDto.setReviews(user.getReviews());
        userDto.setProducts(user.getProducts());
        userDto.setShopCart(user.getShopCart());
        return userDto;
    }

    public UserCreateDto mapUserEntityToCreateDto(User user){
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setName(user.getName());
        userCreateDto.setEmail(user.getEmail());
        userCreateDto.setPassword(user.getPassword());
        userCreateDto.setProfilePicture(user.getProfilePicture());

        List<PhoneCreateDto> phoneCreateDtos = user.getPhones().stream()
                .map(this::mapPhoneEntityToCreateDto)
                .toList();

        userCreateDto.setPhones(phoneCreateDtos);

        List<AddressCreateDto> addressCreateDtos = user.getAddresses().stream()
                .map(this::mapAddressEntityToCreateDto)
                .toList();

        userCreateDto.setAddresses(addressCreateDtos);
        return userCreateDto;
    }

    public User mapUserCreateDtoToEntity(UserCreateDto userCreateDto){
        User user = new User();
        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        user.setProfilePicture(userCreateDto.getProfilePicture());

        List<Phone> phones = userCreateDto.getPhones().stream()
                .map(this::mapPhoneCreateDtoToEntity)
                .toList();

        user.setPhones(phones);

        List<Address> addresses = userCreateDto.getAddresses().stream()
                .map(this::mapAddressCreateDtoToEntity)
                .toList();

        user.setAddresses(addresses);
        return user;
    }

    public PhoneCreateDto mapPhoneEntityToCreateDto(Phone phone){
        PhoneCreateDto phoneCreateDto = new PhoneCreateDto();
        phoneCreateDto.setPhoneNumber(phone.getPhoneNumber());
        return phoneCreateDto;
    }

    public Phone mapPhoneCreateDtoToEntity(PhoneCreateDto phoneCreateDto){
        Phone phone = new Phone();
        phone.setPhoneNumber(phoneCreateDto.getPhoneNumber());
        return phone;
    }

    public AddressCreateDto mapAddressEntityToCreateDto(Address address){
        AddressCreateDto addressCreateDto = new AddressCreateDto();
        addressCreateDto.setState(address.getState());
        addressCreateDto.setCity(address.getCity());
        addressCreateDto.setNeighborhood(address.getNeighborhood());
        addressCreateDto.setStreet(address.getStreet());
        addressCreateDto.setComplement(address.getComplement());
        addressCreateDto.setCep(address.getCep());
        return addressCreateDto;
    }

    public Address mapAddressCreateDtoToEntity(AddressCreateDto addressCreateDto){
        Address address = new Address();
        address.setState(addressCreateDto.getState());
        address.setCity(addressCreateDto.getCity());
        address.setNeighborhood(addressCreateDto.getNeighborhood());
        address.setStreet(addressCreateDto.getStreet());
        address.setComplement(addressCreateDto.getComplement());
        address.setCep(addressCreateDto.getCep());
        return address;
    }


}
