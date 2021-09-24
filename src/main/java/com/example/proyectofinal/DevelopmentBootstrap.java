package com.example.proyectofinal;

import com.example.proyectofinal.model.Product;
import com.example.proyectofinal.repository.ProductRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;


@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private  ProductRepository productRepository;



    public DevelopmentBootstrap(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       // crear();
    }

    private void crear(){
        Product p = new Product();
        p.setStock(new BigDecimal(1));
        p.setName("Manzanas");
        p.setCode("123");
        p.setPrice(new BigDecimal(5));
        productRepository.save(p);

    }


}