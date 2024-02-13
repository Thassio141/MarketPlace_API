package br.com.marketplace.domain.entity;

import br.com.marketplace.domain.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OrderStatus orderStatus;

    private String trackingCode;

    private Date createOrderDate;

    private Date finishOrderDate;
    //fazer relacionamento
    @ManyToOne
    private User user;
    //fazer relacionamento
    @OneToOne
    private ShopCart shopCart;

    @OneToOne
    private Address address;
}
