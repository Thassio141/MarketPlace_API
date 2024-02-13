package br.com.marketplace.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private String city;

    // Bairro
    private String neighborhood;

    // Rua
    private String street;

    private String complement;

    @Size(min = 9, max = 9)
    private String cep;

    // fazer relacionamento com usuario
    @ManyToOne
    private User user;

    @OneToOne
    private Order order;
}
