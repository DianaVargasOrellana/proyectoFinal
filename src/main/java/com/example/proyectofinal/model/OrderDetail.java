package com.example.proyectofinal.model;

import com.example.proyectofinal.dto.OrderDetailDto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class OrderDetail extends ModelBase<OrderDetailDto> {

    @OneToOne()
    private Product product;
    private BigDecimal quanty;
    private boolean discount;
    private BigDecimal total;

    @ManyToOne()
    @JoinColumn(name = "order_id")
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
