package br.com.marketplace.repositories;

import br.com.marketplace.domain.entity.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCartRepository extends JpaRepository<ShopCart,Long> {
}
