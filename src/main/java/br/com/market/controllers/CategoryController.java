package br.com.market.controllers;

import br.com.market.dtos.CategoryDTO;
import br.com.market.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllProductType(){
        List<CategoryDTO> categoryDTO = categoryService.getAllProductType();
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getProductTypeById(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryService.getProductTypeById(id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createProductType(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO productType = categoryService.createProductType(categoryDTO);
        return new ResponseEntity<>(productType,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateProductType(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        CategoryDTO productType = categoryService.updateProductType(id, categoryDTO);
        return new ResponseEntity<>(productType,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductType(@PathVariable Long id){
        categoryService.deleteProductType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
