package br.com.marketplace.domain.entity;

import br.com.marketplace.domain.enumeration.ActivityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private ActivityStatus availability;

    @Lob
    private byte[] image;

    // fazer relacionamento
    @ManyToOne
    private User seller;
    // fazer relacionamento
    @OneToMany
    private List<Review> reviewList = new ArrayList<>();

    // fazer relacionamento
    @ManyToMany
    private Set<ShopCart> shopCarts = new HashSet<>();
}
