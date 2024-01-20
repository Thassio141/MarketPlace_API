package br.com.market.services;

import br.com.market.dtos.CategoryDTO;
import br.com.market.models.CategoryEntity;
import br.com.market.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllProductType(){
        List<CategoryEntity> productType = categoryRepository.findAll();
        return productType.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO getProductTypeById(Long id){
        //TODO error message
        CategoryEntity productType = categoryRepository.findById(id).orElseThrow();
        return convertToDTO(productType);
    }

    public CategoryDTO createProductType(CategoryDTO categoryDTO){
        CategoryEntity productType = convertToEntity(categoryDTO);
        CategoryEntity savedProductType = categoryRepository.save(productType);
        return convertToDTO(savedProductType);
    }

    public CategoryDTO updateProductType(Long id, CategoryDTO categoryDTO){
        //TODO error message
        CategoryEntity productType = categoryRepository.findById(id).orElseThrow();
        productType.setName(categoryDTO.getName());
        CategoryEntity updateProductType = categoryRepository.save(productType);
        return convertToDTO(updateProductType);
    }
    public void deleteProductType(Long id){
        //TODO error message
        CategoryEntity productType = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(productType);
    }

    private CategoryDTO convertToDTO(CategoryEntity product) {
        return modelMapper.map(product, CategoryDTO.class);
    }

    private CategoryEntity convertToEntity(CategoryDTO productDTO) {
        return modelMapper.map(productDTO, CategoryEntity.class);
    }
}
