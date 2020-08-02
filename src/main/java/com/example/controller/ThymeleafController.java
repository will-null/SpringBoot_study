package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/t")
    public String index(Model model) {
        model.addAttribute("msg","thymeleaf第一次!");
        model.addAttribute("list", Arrays.asList("alden","ade","john"));
        return "index";
    }

}
