package com.example.proyectofinal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping("/g")
    @ResponseBody
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
       // ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("greeting");
        //return modelAndView;
        return "greeting";
    }

}