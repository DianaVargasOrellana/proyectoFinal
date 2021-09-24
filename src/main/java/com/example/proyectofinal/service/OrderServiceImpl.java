package com.example.proyectofinal.service;

import com.example.proyectofinal.exceptions.NotFoundException;
import com.example.proyectofinal.model.Order;
import com.example.proyectofinal.model.OrderDetail;
import com.example.proyectofinal.model.Product;
import com.example.proyectofinal.repository.GenericRepository;
import com.example.proyectofinal.repository.OrderRespository;
import com.example.proyectofinal.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order>{
    private final OrderRespository repository;
    private OrderDetailServiceImpl orderDetailService;

    public OrderServiceImpl(OrderRespository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Order> getRepository() {
        return repository;
    }

    public Order save(Order order){
        Order orderSave = this.repository.save(order);
        return orderSave;
    }

    public Order clearOrdersDetails(Order order){
        order.setOrderDetails(new ArrayList<>());
        Order orderSave = repository.save(order);
        return orderSave;
    }

    public void deleteOrder(Order o){
        repository.delete(o);
    }

    public Order finaliceOrder(Order o){
        List<OrderDetail> orders = o.getOrderDetails();
        if(orders == null || orders.size() < 0){
            throw new NotFoundException("Ordenes no encontradas");
        }
        for (OrderDetail oD : orders){
            orderDetailService.sellOrder(oD);
        }
        return o;
    }
}
