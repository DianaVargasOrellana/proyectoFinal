package com.example.proyectofinal.model;

import com.example.proyectofinal.dto.OrderDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Order extends ModelBase<OrderDto>{

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails ;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    private BigDecimal totalAmout;

    public void addToList(OrderDetail o){
        orderDetails.add(o);
    }

    public void remove(OrderDetail o){
        orderDetails.remove(o);
    }

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
