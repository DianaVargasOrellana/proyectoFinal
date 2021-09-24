package com.example.proyectofinal.controller;

import com.example.proyectofinal.dto.ProductDto;
import com.example.proyectofinal.model.Product;
import com.example.proyectofinal.service.ProductService;
import com.example.proyectofinal.service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController extends GenericController<Product, ProductDto>{
    private ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }


    @Override
    protected ProductServiceImpl getService() {
       return service;
    }


   @GetMapping(value = "/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/add_product";
    }

    @GetMapping(value = "/show")
    public String showProduct(Model model) {
        model.addAttribute("productos", service.findAll());
        return "product/show_product";
    }

    @PostMapping(value = "/eliminar")
    public String deleteProduct(@ModelAttribute Product product, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensaje", "Eliminado correctamente")
                .addFlashAttribute("clase", "warning");
        service.deleteByCode(product.getCode());
        return "redirect:/product/show";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateProduct(@ModelAttribute @Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        service.save(product);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/product/show";
    }

    @GetMapping(value = "/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.findById(id));
        return "productos/edit_producto";
    }

    @PostMapping(value = "/add")
    public String saveProduct(@ModelAttribute @Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        service.save(product);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/product/add";
    }




}
