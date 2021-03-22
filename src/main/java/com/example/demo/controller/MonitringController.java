package com.example.demo.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/monitring")
@Controller
@AllArgsConstructor
public class MonitringController {

    @GetMapping("/grfanaview")
    public String index() {
        return "monitringview";
    }


}
