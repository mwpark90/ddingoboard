package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String mainView(){

        return "Hello";
    }

}
