package com.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParamController {
    @RequestMapping("/param/form")
    public String form() {
        return "form";
    }

    @RequestMapping(value = "/param/save/{x}", method = RequestMethod.POST)
    public String save(@PathVariable("x") String x,
                       @RequestParam("y") String y,
                       Model model) {
        // Đưa giá trị x và y ra view
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "form";
    }
}

