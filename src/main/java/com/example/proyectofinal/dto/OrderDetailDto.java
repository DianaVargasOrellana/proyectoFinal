package com.example.proyectofinal.dto;

import com.example.proyectofinal.model.Order;
import com.example.proyectofinal.model.OrderDetail;
import com.example.proyectofinal.model.Product;

import java.math.BigDecimal;

public class OrderDetailDto extends  DtoBase<OrderDetail>{

    private Product product;
    private BigDecimal quanty;
    private boolean discount;
    private BigDecimal total;
    private Order order;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuanty() {
        return quanty;
    }

    public void setQuanty(BigDecimal quanty) {
        this.quanty = quanty;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
