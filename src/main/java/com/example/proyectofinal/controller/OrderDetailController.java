package com.example.proyectofinal.controller;

import com.example.proyectofinal.dto.OrderDetailDto;
import com.example.proyectofinal.model.Order;
import com.example.proyectofinal.model.OrderDetail;
import com.example.proyectofinal.model.Product;
import com.example.proyectofinal.service.OrderDetailService;
import com.example.proyectofinal.service.OrderDetailServiceImpl;
import com.example.proyectofinal.service.OrderServiceImpl;
import com.example.proyectofinal.service.ProductServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/orderDetail")
public class OrderDetailController extends GenericController<OrderDetail, OrderDetailDto> {
    private OrderDetailServiceImpl service;
    private OrderServiceImpl orderService;

    public OrderDetailController(OrderDetailServiceImpl service) {
        this.service = service;
    }


    @Override
    protected OrderDetailServiceImpl getService() {
        return service;
    }


    @PostMapping(value = "/add")
    public String addToOrder(@ModelAttribute OrderDetail order, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        service.saveOrder(order);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/order";
    }


    @PostMapping(value = "/delete/{id}")
    public String deleteFromOrder(@PathVariable Long id, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensaje", "Eliminado correctamente")
                .addFlashAttribute("clase", "warning");
        service.deleteOrder(id);
        return "redirect:/order";
    }

}