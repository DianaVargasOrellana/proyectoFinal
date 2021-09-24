package com.example.proyectofinal.model;

import com.example.proyectofinal.dto.ProductDto;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Product extends ModelBase<ProductDto>{
    @NotNull(message = "You should specified the name")
    private String name;

    @NotNull(message = "You should specified the code")
    private String code;

    @NotNull(message = "You should specified the price")
    private BigDecimal price;

    @NotNull(message = "You should specified the quanty stock")
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
