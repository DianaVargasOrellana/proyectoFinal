package com.example.proyectofinal.dto;

import com.example.proyectofinal.model.Product;

import java.math.BigDecimal;

public class ProductDto extends DtoBase<Product>{
    private String name;
    private String code;
    private Float price;
    private BigDecimal stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
