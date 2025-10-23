package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
        private List<Product> items = new ArrayList<>(Arrays.asList(new Product("A", 1.0), new Product("B", 12.0)));

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone");
        p.setPrice(5000.0);

        model.addAttribute("product1", p);

        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product2") Product p, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("product2" ,p);
        items.add(p);
        return "redirect:/product/form";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return items;
    }
}
