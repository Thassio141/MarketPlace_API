package br.com.marketplace.services;

import br.com.marketplace.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    private final MapperService mapperService;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, MapperService mapperService) {
        this.phoneRepository = phoneRepository;
        this.mapperService = mapperService;
    }
}
