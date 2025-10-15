package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.dao.ProductDAO;
import com.entity.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/product/sort")
    public String sort(Model model,
                       @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }

    @RequestMapping("/product/page")
    public String paginate(Model model,
                           @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }

    @RequestMapping("/product/sort-page")
    public String sortAndPaginate(Model model,
                                  @RequestParam("field") Optional<String> field,
                                  @RequestParam("p") Optional<Integer> p) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));

        Pageable pageable = PageRequest.of(p.orElse(0), 5, sort);

        Page<Product> page = dao.findAll(pageable);

        model.addAttribute("page", page);
        model.addAttribute("field", field.orElse("price").toUpperCase());

        return "product/sort-page";
    }
}
