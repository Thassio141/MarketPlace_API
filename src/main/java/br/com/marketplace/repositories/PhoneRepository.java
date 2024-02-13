package br.com.marketplace.repositories;

import br.com.marketplace.domain.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
