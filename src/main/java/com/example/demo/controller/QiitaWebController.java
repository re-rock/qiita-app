package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QiitaWebController {
    
    @Autowired
    QiitaService qiitaService;

    @GetMapping(value = "/items")
    public ModelAndView showAllItemsPage() {
        ModelAndView modelAndView = new ModelAndView("Items");

        List<QiiitaItems> items = qiitaService.findAll();
        modelAndView.addObject("items", items);
        return modelAndView;
    }
}