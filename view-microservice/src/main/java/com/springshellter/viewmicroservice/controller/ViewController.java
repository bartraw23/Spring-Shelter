package com.springshellter.viewmicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shellter")
public class ViewController {

    @GetMapping("form")
    public String addAnimalForm() {
        return "form";
    }
}
