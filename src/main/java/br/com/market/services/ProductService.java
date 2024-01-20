package br.com.market.services;

import br.com.market.dtos.ProductDTO;
import br.com.market.enums.ProductStatus;
import br.com.market.models.ProductEntity;
import br.com.market.repositories.ProductRepository;
import br.com.market.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> product = productRepository.findAll();
        return product.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id){
        // ToDo error message
        ProductEntity product = productRepository.findById(id).orElseThrow();
        return convertToDTO(product);
    }
    public ProductDTO createProduct(ProductDTO productDTO){
        ProductEntity product = convertToEntity(productDTO);
        ProductEntity savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        // ToDo error message
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        ProductEntity updateProduct = productRepository.save(product);
        return convertToDTO(updateProduct);
    }

//    @Transactional
//    public void addProductTypeToProduct(Long idProduct,Long idProductType){
//        ProductEntity product = productRepository.findById(idProduct).orElseThrow();
//
//        ProductTypeEntity productType = productTypeRepository.findById(idProductType).orElseThrow();
//
//        product.getProductTypes().add(productType);
//        productType.getProducts().add(product);
//
//        ProductEntity savedProduct = productRepository.save(product);
//    }

    public ProductDTO activateProduct(Long id){
        // ToDo error message
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setProductStatus(ProductStatus.ACTIVE);
        ProductEntity updateProduct = productRepository.save(product);
        return convertToDTO(updateProduct);
    }
    public ProductDTO softDeleteProduct(Long id){
        // ToDo error message
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setProductStatus(ProductStatus.INACTIVE);
        ProductEntity updateProduct = productRepository.save(product);
        return convertToDTO(updateProduct);
    }

    public void deleteProduct(Long id){
        //ToDo error message
        ProductEntity product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    private ProductDTO convertToDTO(ProductEntity product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    private ProductEntity convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductEntity.class);
    }

}
