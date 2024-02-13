package br.com.marketplace.services;

import br.com.marketplace.domain.dto.user.UserCreateDto;
import br.com.marketplace.domain.entity.User;
import br.com.marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final MapperService mapperService;

    @Autowired
    public UserService(UserRepository userRepository, MapperService mapperService) {
        this.userRepository = userRepository;
        this.mapperService = mapperService;
    }

    public UserCreateDto create(UserCreateDto userCreateDto){
        User user = mapperService.mapUserCreateDtoToEntity(userCreateDto);

        return mapperService.mapUserEntityToCreateDto(userRepository.save(user));
    }
}
