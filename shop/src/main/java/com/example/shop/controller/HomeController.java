package com.example.shop.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 首页
 *
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "hi";
    }
}
