package br.com.marketplace.domain.entity;

import br.com.marketplace.domain.enumeration.ActivityStatus;
import br.com.marketplace.domain.enumeration.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private ActivityStatus userStatus;

    @Lob
    private byte[] profilePicture;
    // fazer relacionamento com telefone
    @OneToMany
    private List<Phone> phones = new ArrayList<>();

    // fazer relacionamento com endereço
    @OneToMany
    private List<Address> addresses = new ArrayList<>();

    // fazer relacionamento com avaliacao
    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    @OneToMany
    private List<Product> products = new ArrayList<>();

    @OneToOne
    private ShopCart shopCart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
