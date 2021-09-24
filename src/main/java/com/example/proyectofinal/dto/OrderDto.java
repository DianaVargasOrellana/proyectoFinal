package com.example.proyectofinal.dto;

import com.example.proyectofinal.model.Client;
import com.example.proyectofinal.model.Order;
import com.example.proyectofinal.model.OrderDetail;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

public class OrderDto extends DtoBase<Order>{

    private List<OrderDetail> orderDetails;

    private Client client;

    private BigDecimal totalAmout;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(BigDecimal totalAmout) {
        this.totalAmout = totalAmout;
    }
}
