package br.com.market.controllers;

import br.com.market.dtos.ProductDTO;
import br.com.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTO = productService.getAllProducts();
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO productDTO = productService.getProductById(id);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO product = productService.createProduct(productDTO);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        ProductDTO product = productService.updateProduct(id,productDTO);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

//    @PutMapping("/addtype/{idproduct}/{idproducttype}")
//    public ResponseEntity<Void> addProductTypeToProduct(@PathVariable Long idproduct, @PathVariable Long idproducttype){
//        productService.addProductTypeToProduct(idproduct,idproducttype);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<ProductDTO> activateProduct(@PathVariable Long id){
        ProductDTO productDTO = productService.activateProduct(id);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @PutMapping("/softdelete/{id}")
    public ResponseEntity<ProductDTO> softDeleteProduct(@PathVariable Long id){
        ProductDTO productDTO = productService.softDeleteProduct(id);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
