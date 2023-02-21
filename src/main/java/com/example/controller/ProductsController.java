package com.example.controller;

import com.example.dto.PageRequestDto;
import com.example.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/techsupp")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/")
    public String index() {
        return "Product/list";
    }

//    @GetMapping("/list")
//    public void list(@ModelAttribute PageRequestDto pageRequestDto, Model model) {
//        model.addAttribute("result", productsService.getList(pageRequestDto));
//    }
}
