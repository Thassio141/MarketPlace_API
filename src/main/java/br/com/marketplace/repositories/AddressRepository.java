package br.com.marketplace.repositories;

import br.com.marketplace.domain.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    Page<Address> findAll(Pageable pageable);

}
