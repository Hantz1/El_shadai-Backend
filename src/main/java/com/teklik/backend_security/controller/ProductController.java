package com.teklik.backend_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teklik.backend_security.exception.ResourceNotFoundException;
import com.teklik.backend_security.model.Product;
import com.teklik.backend_security.repository.ProductRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable  long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id:" + id));
        return ResponseEntity.ok(product);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product productParams) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not exist with id:" + id));

                product.setTitle(productParams.getTitle());
                product.setCategory(productParams.getCategory());
                product.setPrice(productParams.getPrice());
                product.setCapacity(productParams.getCapacity());
                product.setQty(productParams.getQty());
                product.setDescribe(productParams.getDescribe());
                product.setDatecreated(productParams.getDatecreated());

        productRepository.save(product);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProducts(@PathVariable long id){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order not exist with id: " + id));

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
