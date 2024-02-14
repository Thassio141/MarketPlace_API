package br.com.marketplace.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop_cart")
public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //relacionamento
    @ManyToMany
    private Set<Product> products = new HashSet<>();

    @OneToOne
    private User user;

    @OneToOne
    private Order order;
}
