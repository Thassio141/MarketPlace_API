package br.com.marketplace.repositories;

import br.com.marketplace.domain.entity.ShopCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopCartRepository extends JpaRepository<ShopCart, UUID> {

    Page<ShopCart> findAll(Pageable pageable);

}
