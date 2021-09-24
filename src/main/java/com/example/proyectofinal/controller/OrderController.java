package com.example.proyectofinal.controller;

import com.example.proyectofinal.dto.OrderDetailDto;
import com.example.proyectofinal.dto.OrderDto;
import com.example.proyectofinal.model.Order;
import com.example.proyectofinal.model.OrderDetail;
import com.example.proyectofinal.service.OrderDetailServiceImpl;
import com.example.proyectofinal.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/order")
public class OrderController extends GenericController<Order, OrderDto> {
    private OrderServiceImpl service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }


    @Override
    protected OrderServiceImpl getService() {
        return service;
    }


    @GetMapping(value = "/clean")
    public String deleteOrder(@ModelAttribute Order order, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        service.deleteOrder(order);
        redirectAttrs
                .addFlashAttribute("mensaje", "Orden cancelada")
                .addFlashAttribute("clase", "info");
        return "redirect:/order";
    }

    @PostMapping(value = "/finaliceOrder")
    public String finaliceOrder(@ModelAttribute Order order, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        service.finaliceOrder(order);
        service.deleteOrder(order);
        redirectAttrs
                .addFlashAttribute("mensaje", "Orden de venta realizada correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/order";
    }
}
