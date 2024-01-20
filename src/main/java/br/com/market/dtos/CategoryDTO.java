package br.com.market.dtos;

import br.com.market.models.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    private Set<ProductEntity> productEntities;
}
