package com.example.proyectofinal.service;

import com.example.proyectofinal.model.Product;
import com.example.proyectofinal.repository.GenericRepository;
import com.example.proyectofinal.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product>{
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Product> getRepository() {
        return repository;
    }


    public void save(String name, String code, BigDecimal stock, BigDecimal price) {
        Product saveProduct = findByCode(code);
        if(saveProduct == null){
            saveProduct = new Product();
            saveProduct.setName(name);
            saveProduct.setCode(code);
            saveProduct.setStock(stock);
            saveProduct.setPrice(price);
        }
        this.repository.save(saveProduct);
    }

    public void deleteByCode(String code){
        Product p = findByCode(code);
        repository.delete(p);
    }

    public void deleteByStock(String code, BigDecimal stocktodelete){
        Product p = findByCode(code);
        p.setStock(p.getStock().subtract(stocktodelete));
        repository.save(p);
    }

    public Product findByCode(String code) {
        Product productbycode = this.repository.findByCode(code);
        return productbycode;
    }
}

