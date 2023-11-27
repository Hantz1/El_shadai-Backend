package com.teklik.backend_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teklik.backend_security.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    
}