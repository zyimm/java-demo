package com.example.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author ZYIMM
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("list")
    public void productList(){

    }
}
