package com.example.proyectofinal.model;

import com.example.proyectofinal.dto.ClientDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client extends ModelBase<ClientDto>{
    private String name;
    private String lastName;
    private String email;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
