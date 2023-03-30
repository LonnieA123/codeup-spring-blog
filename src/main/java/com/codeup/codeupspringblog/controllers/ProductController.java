package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {



    @GetMapping("/products/create")
    public String productsview(){
        return "products";
    }


    @PostMapping("/products/create")
    public String insertString(@RequestParam String name, @RequestParam String price){
        System.out.println(name);
        System.out.println(price);

        return "redirect:/posts";
    }
}
