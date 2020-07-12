package com.springshelter.viewmicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shelter")
public class ViewController {

    @GetMapping("form")
    public String addAnimalForm() {
        return "form";
    }
}
