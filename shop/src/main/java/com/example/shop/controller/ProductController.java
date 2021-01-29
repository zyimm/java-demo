package com.example.shop.controller;

import cn.hutool.core.date.DateUtil;
import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.service.product.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ProductServiceImpl productService;

    @Autowired
    public void setProductService(ProductServiceImpl productService){
        this.productService = productService;
    }

    @GetMapping("list")
    @PassToken(required = false)
    public Object productList(){
        return Result.success(this.productService.listProduct());
    }
}
