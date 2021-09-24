package com.example.proyectofinal.service;

import com.example.proyectofinal.exceptions.NotFoundException;
import com.example.proyectofinal.model.Order;
import com.example.proyectofinal.model.OrderDetail;
import com.example.proyectofinal.model.Product;
import com.example.proyectofinal.repository.GenericRepository;
import com.example.proyectofinal.repository.OrderDetailRepository;
import com.example.proyectofinal.repository.OrderRespository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderDetailServiceImpl extends GenericServiceImpl<OrderDetail>{
    private final OrderDetailRepository repository;
    private ProductServiceImpl productService;
    private OrderServiceImpl orderService;

    public OrderDetailServiceImpl(OrderDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<OrderDetail> getRepository() {
        return repository;
    }


    public OrderDetail saveOrder(OrderDetail orderDetail){
        repository.save(orderDetail);
        Order updateOrder = orderDetail.getOrder();
        updateOrder.addToList(orderDetail);
        orderService.save(updateOrder);
        return orderDetail;
    }


    public OrderDetail sellOrder(OrderDetail orderDetail){
        OrderDetail orderDetailsave = this.repository.save(orderDetail);
        Product producttoFind = orderDetailsave.getProduct();
        Product productoninventory = productService.findByCode(producttoFind.getCode());
        if (productoninventory == null){
            throw new NotFoundException("Producto no encontrado");
        }
        if ((producttoFind.getStock()).compareTo(orderDetail.getQuanty()) == -1){
            throw new NotFoundException("No existe la cantidad requerida para este producto");
        }
        BigDecimal cantidad = orderDetailsave.getQuanty();
        productoninventory.setStock((productoninventory.getStock()).subtract(cantidad));
        productService.save(productoninventory);
        repository.save(orderDetail);
        return orderDetailsave;
    }

    public  void deleteOrder(Long id){
        OrderDetail orderDetail = findById(id);
        Product productonInventory = orderDetail.getProduct();
        BigDecimal cantidad = orderDetail.getQuanty();

        productonInventory.setStock((productonInventory.getStock()).add(cantidad));
        Order updateOrder = orderDetail.getOrder();
        updateOrder.remove(orderDetail);
        orderService.save(updateOrder);
        productService.save(productonInventory);
        repository.delete(orderDetail);
    }




}
