package com.example.proyectofinal.repository;

import com.example.proyectofinal.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepository<Product>{
    Product findByCode(String code);
}
